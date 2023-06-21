<template>
    <mainHeader />
    <v-main>
        <roomList />
    </v-main>
    <createRoomFooter />
</template>
  
<script>
import mainHeader from '@/components/header/mainHeader.vue';
import createRoomFooter from '@/components/footer/createRoomFooter.vue';
import roomList from '@/components/roomList.vue'
export default {
    name: 'roomListView',
    data() {
        return {
        }
    },
    components: {
        roomList,
        mainHeader,
        createRoomFooter
    },
    methods: {
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
  