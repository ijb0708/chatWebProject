<template>
    <mainHeader />
    <v-main>
        <div class="register-form-container">
            <registerForm @clickConfirm="handleClickConfirm"/>
        </div>
    </v-main>
    <mainFooter />
</template>
  
<script>
import mainHeader from '@/components/header/mainHeader.vue';
import mainFooter from '@/components/footer/mainFooter.vue';
import registerForm from '@/components/registerForm.vue'
export default {
    name: 'registerView',
    data() {
        return {
        }
    },
    components: {
        registerForm,
        mainHeader,
        mainFooter
    },
    methods: {
        handleClickConfirm(data) {
            console.log(data)
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
  