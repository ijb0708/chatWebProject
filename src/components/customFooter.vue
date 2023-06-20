<template>
    <v-footer app color="primary">
        <v-row justify="center" align="center">
            <v-col cols="auto">
                <v-btn rounded color="secondary" class="text-lg" @click="goHome">홈</v-btn>
            </v-col>
            <v-col cols="auto">
                <v-btn rounded color="secondary" class="text-lg" @click="goBack">뒤로가기</v-btn>
            </v-col>
        </v-row>
    </v-footer>
</template>

<script>
export default {
    name: 'customFooter',
    methods: {
        goBack() {
        // 뒤로가기 동작 처리
        },
        goHome() {
        // 홈으로 이동 동작 처리
        }
    }
}
</script>

<style>
    .text-lg {
        font-size: 20px;
    }
</style>