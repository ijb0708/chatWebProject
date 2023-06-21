<template>
    <v-container>
        <v-list lines="one">
            <v-list-item
                v-for="(chat, idx) in chatlist"
                :key="idx"
                :title="chat.user"
                :subtitle="chat.message"
            ></v-list-item>
        </v-list>
    </v-container>
</template>

<script>
export default {
    name: 'chatList',
    props: {
        chatList: {
            type: Array,
            default: []
        }
    },
    methods: {
    },
}
</script>