<template>
    <div class="login-form-container">
        <registerForm />
    </div>
</template>
  
<script>
import registerForm from '@/components/registerForm.vue'
export default {
    name: 'registerView',
    data() {
        return {
        }
    },
    components: {
        registerForm
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
  