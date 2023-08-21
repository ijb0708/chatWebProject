<template>
    <v-app-bar color="blue" app>
        <v-app-bar-nav-icon @click="clickBackBtn">
            <v-icon color="white">mdi-arrow-left</v-icon>    
        </v-app-bar-nav-icon>
        <v-toolbar-title class="white--text">
            {{ headerName }}
        </v-toolbar-title> 
        <v-spacer></v-spacer>
        <v-btn icon @click="clickRefreshBtn">
            <v-icon color="white">mdi-refresh</v-icon>
        </v-btn>
    </v-app-bar>
</template>

<script>
export default {
    name: 'refreshHeader',
    props: {
        headerName: {
            type: String,
            default: ''
        }
    },
    methods: {
        clickBackBtn() {
            this.$emit('clickBackBtn')
        },
        clickRefreshBtn() {
            this.$emit('clickRefreshBtn')
        }
    }
}
</script>