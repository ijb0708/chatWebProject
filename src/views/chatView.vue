<template>
    <chatHeader />
    <v-main>
        <msgSendFooter :chatList="this.chatList"/>
    </v-main>
    <msgFooter @clickSend="handleClickSend" />
</template>

<script>
import chatHeader from '@/components/header/chatHeader.vue'
import msgSendFooter from '@/components/footer/msgSendFooter.vue'
import chatList from '@/components/chatList.vue'
export default {
	name: 'chatView',
	components: {
        chatHeader,
		msgSendFooter,
        chatList
	},
    data() {
        return {
            chatlist: [
                {
                    user:'1',
                    message:'tt'
                },
                {
                    user:'2',
                    message:'tt'
                }
            ],
        }
    },
    methods:{
        handleClickSend(msg) {
            console.log(msg)
        }
    }
}
</script>

<style>
</style>