<template>
	<v-container fluid>
		<v-row justify="center" align="center" class="login-row">
			<v-col cols="12" sm="8" md="6" lg="4">
				<v-card>
					<v-card-title class="text-center">로그인</v-card-title>
					<v-card-text>
						<v-text-field
							v-model="userid"
							label="ID"
							outlined
							required
						></v-text-field>
						<v-text-field
							v-model="password"
							label="비밀번호"
							outlined
							type="password"
							required
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
				</v-card>
			</v-col>
		</v-row>
	</v-container>
</template>
  
<script>
  export default {
    data() {
      return {
        userid: '',
        password: '',

        fields: {
                userid: '',
                nickname: '',
                password: '',
                confirmPassword: '',
        }
      };
    },
    methods: {
      clickLogin() {
        this.$emit('clickLogin', {
          userid: this.userid,
          password: this.password
        })
      },
      clickGoRegister() {
        this.$emit('clickRegister')
      }
    },
  }
</script>
  