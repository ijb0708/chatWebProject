<template>
	<mainHeader />
	<v-main>
        <div class="login-form-container">
			<loginForm
				@clickLogin="handleClickLogin"
				@clickRegister="handleClickGoRegister" 
			/>
		</div>
	</v-main>
	<mainFooter />
</template>

<script>
import customAxios from '@/api/axiosInit'
import mainHeader from '@/components/header/mainHeader.vue';
import mainFooter from '@/components/footer/mainFooter.vue';
import loginForm from '@/components/form/loginForm.vue'
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
		async handleClickLogin(data) {
			const resData = await this.$axios.login(data.userid, data.password)
			if(resData.auth) {
				this.$store.dispatch('auth/setToken', resData.token)
				this.$router.push('/rooms/list')
			}else {
				alert(resData.message)
			}
		},
		handleClickGoRegister() {
			this.$router.push('/users/register')
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
