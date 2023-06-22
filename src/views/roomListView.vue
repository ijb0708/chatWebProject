<template>
    <refreshHeader 
        headerName="ROOMS"
        @clickBackBtn="handleClickBackBtn" 
        @clickRefreshBtn="handleClickRefreshBtn"
    />
    <v-main>
        <roomList 
            :list="this.array.roomList"
            @clickEnterRoom="handleClickEnterRoom"
            @clickDeleteRoom="handleClickDeleteRoom"
        />
    </v-main>
    <createRoomFooter
        @clickCreateRoom="handleClickCreateRoom"
    />
</template>
  
<script>
import refreshHeader from '@/components/header/refreshHeader.vue';
import createRoomFooter from '@/components/footer/createRoomFooter.vue';
import roomList from '@/components/list/roomList.vue'
export default {
    name: 'roomListView',
    data() {
        return {
            array: {
                roomList: []
            }
        }
    },
    components: {
        roomList,
        refreshHeader,
        createRoomFooter
    },
    created() {
        this.refreshRoomList()
    },
    methods: {
        handleClickBackBtn() {
            // 로그아웃하고 나가기
			this.$store.dispatch('auth/resetToken')
            this.$router.push('/')
        },
        async handleClickRefreshBtn() {
            this.refreshRoomList()
        },
        async handleClickCreateRoom(data) {
            const resData = await this.$axios.registerRoom(data)
            refreshRoomList()
            console.log(resData)
        },
        async handleClickEnterRoom(data) {
            console.log(data)
            const resData = await this.$axios.enterRoom(data)
            console.log(resData)
            if( !resData.isSucc ) {
                return 
            }
            this.$router.push('/rooms/chat?room_access_token=' + resData.room_access_token);
        },
        async handleClickDeleteRoom(data) {
            console.log(data)
            await this.$axios.deleteRoom(data)
        },
        async refreshRoomList() {
            const resData = await this.$axios.listAllRooms()
            this.array.roomList = resData.data.rooms
        }
    }
}
</script>

<style>
    .login-form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 70vh;
    }
</style>
  