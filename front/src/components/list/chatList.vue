<template>
    <v-card class="mx-auto">
        <v-list lines="one">
            <v-list-item
                v-for="(item, idx) in list"
                :key="idx"
            >
            <v-list-item-title>{{ item.message }}</v-list-item-title>
            <v-list-item-subtitle>from: {{ item.user }}</v-list-item-subtitle>
            </v-list-item>
        </v-list>
    </v-card>
</template>

<script>
export default {
    name: 'chatList',
    props: {
        list: {
            type: Array,
            default: []
        }
    },
}
</script>