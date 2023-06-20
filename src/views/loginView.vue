<template>
	<loginForm
		@clickLogin="handleClickLogin"
		@clickRegister="handleclickGoRegister" 
	/>
</template>

<script>
import loginForm from '@/components/loginForm.vue'
export default {
	name: 'loginView',
	components: {
		loginForm
	},
	data() {
		return {
		}
	},
	methods: {
		handleClickLogin(data) {
			console.log(data)
		},
		handleclickGoRegister() {
			console.log('register')
		}
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
