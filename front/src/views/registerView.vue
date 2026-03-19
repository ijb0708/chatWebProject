<template>
    <backHeader headerName="chat" @clickBackBtn="handleClickBackBtn"/>
    <v-main>
        <div class="register-form-container">
            <registerForm @clickConfirm="handleClickConfirm"/>
        </div>
    </v-main>
    <mainFooter />
</template>
  
<script>
import backHeader from '@/components/header/backHeader.vue'
import mainFooter from '@/components/footer/mainFooter.vue';
import registerForm from '@/components/form/registerForm.vue'
export default {
    name: 'registerView',
    data() {
        return {
        }
    },
    components: {
        registerForm,
        backHeader,
        mainFooter
    },
    methods: {
        async handleClickConfirm(data) {
            
            const resData = await this.$axios.registerUser(data.userid, data.nickname, data.password)
            this.$router.push('/')
        },
        handleClickBackBtn() {
            this.$router.push('/')
        }
    }
}
</script>

<style>
    .register-form-container {
        display: flex;
        justify-content: center;
        align-items: center;
        height: 70vh;
    }
</style>
  