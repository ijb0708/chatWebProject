<template>
	<v-container fluid>
		<v-row justify="center" align="center" class="login-row">
			<v-col cols="12" sm="8" md="6" lg="4">
				<v-card>
                    <v-form ref="form">
						<v-card-title class="text-center">로그인</v-card-title>
						<v-card-text>
							<v-text-field
								v-model="this.fields.userid"
								label="아이디"
								outlined
								required
                                :rules="[
                                    value => Boolean(value) || '*아이디를 입력해주세요',
                                    value => value.length >= 8 || '*아이디는 8자리 이상입니다.',
                                    value => value.length <= 20 || '*아이디는 20자리 이하입니다.',
                                ]"
							></v-text-field>
							<v-text-field
								v-model="this.fields.password"
								label="비밀번호"
								outlined
								type="password"
								required
                                :rules="[
                                    value => Boolean(value) || '*비밀번호를 입력해주세요',
                                    value => value.length >= 8 || '*비밀번호는 8자리 이상입니다.',
                                    value => value.length <= 20 || '*비밀번호는 20자리 이하입니다.',
                                ]"
							></v-text-field>
							<v-row justify="center">
								<v-col cols="auto">
								<v-btn color="primary" @click="clickLogin">로그인</v-btn>
								</v-col>
								<v-col cols="auto">
								<v-btn color="primary" @click="clickGoRegister">회원가입</v-btn>
								</v-col>
							</v-row>
						</v-card-text>
                    </v-form>
				</v-card>
			</v-col>
		</v-row>
	</v-container>
</template>
  
<script>
export default {
	data() {
		return {

			fields: {
				userid: '',
				password: '',
			}
		};
	},
	methods: {
		async clickLogin() {
			const { valid } = await this.$refs.form.validate()
            if( !valid ) {
                return
            }
			
			this.$emit('clickLogin', {
				userid: this.fields.userid,
				password: this.fields.password
			})
		},
		clickGoRegister() {
			this.$emit('clickRegister')
		}
	},
}
</script>
  