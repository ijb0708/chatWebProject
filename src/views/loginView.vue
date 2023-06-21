<template>
	<mainHeader />
	<v-main>
        <div class="login-form-container">
			<loginForm
				@clickLogin="handleClickLogin"
				@clickRegister="handleclickGoRegister" 
			/>
		</div>
	</v-main>
	<mainFooter />
</template>

<script>
import mainHeader from '@/components/header/mainHeader.vue';
import mainFooter from '@/components/footer/mainFooter.vue';
import loginForm from '@/components/loginForm.vue'
export default {
	name: 'loginView',
	components: {
		loginForm,
		mainHeader,
		mainFooter
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
