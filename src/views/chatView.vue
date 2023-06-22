<template>
    <backHeader @clickBackBtn="handleClickBackBtn" />
    <v-main>
        <v-container>
            <chatList :list="this.array.chatList" />
        </v-container>
    </v-main>
    <msgSendFooter @clickSend="handleClickSend" />
</template>

<script>
import backHeader from '@/components/header/backHeader.vue'
import msgSendFooter from '@/components/footer/msgSendFooter.vue'
import chatList from '@/components/list/chatList.vue'
import io from 'socket.io-client';
export default {
	name: 'chatView',
	components: {
        backHeader,
		msgSendFooter,
        chatList
	},
    data() {
        return {
            socket: null,
            array: {
                chatList: []
            },
        }
    },
    created() {
        console.log(import.meta.env.VITE_SOCKET_URL)
        this.socket = io(import.meta.env.VITE_SOCKET_URL + '?token=' + this.$route.query.room_access_token)
        this.socket.on('chat', this.handleReciveChat);
        this.socket.on('system', this.handleReciveSystem);
    },
    methods:{
        handleClickSend(msg) {
            this.socket.emit('chat', msg)
            this.array.chatList.push({
                user: 'me',
                message: msg
            })
        },
        handleReciveChat(data) {
            this.array.chatList.push({
                user: data.sendUser,
                message: data.message
            })
        },
        handleReciveSystem(data) {
            this.array.chatList.push({
                user: "system",
                message: data.message
            })
        },
        handleClickBackBtn() {
            this.socket.emit('leave')
            this.$router.push('/rooms/list')
        }
    }
}
</script>