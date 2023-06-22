<template>
    <v-container fluid>
        <v-row justify="center" align="center" class="login-row">
            <v-col cols="12" sm="8" md="6" lg="4">
                <v-card>
                    <v-form ref="form">
                        <v-card-title class="text-center">회원가입</v-card-title>
                        <v-card-text>
                            <v-text-field
                                v-model="fields.userid"
                                label="아이디"
                                outlined
                                required
                                :rules="[
                                    value => Boolean(value) || '*아이디를 입력해주세요',
                                    value => value.length >= 8 || '*아이디는 8자리 이상입니다.',
                                    value => value.length <= 18 || '*아이디는 18자리 이하입니다.',
                                    () => states.checklDupl || '*아이디가 중복되었습니다.'
                                ]"
                                @input="states.checklDupl = true"
                            ></v-text-field>
                            <v-text-field
                                v-model="fields.nickname"
                                label="닉네임"
                                outlined
                                required
                                :rules="[
                                    value => Boolean(value) || '*닉네임을 입력해주세요',
                                    value => value.length >= 3 || '*닉네임은 3자리 이상입니다.',
                                    value => value.length <= 10 || '*닉네임은 10자리 이하입니다.',
                                ]"
                            ></v-text-field>
                            <v-text-field
                                v-model="fields.password"
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
                            <v-text-field
                                v-model="fields.confirmPassword"
                                label="비밀번호확인"
                                outlined
                                type="password"
                                required
                                :rules="[
                                    value => Boolean(value) || '*비밀번호를 입력해주세요',
                                    value => value.length >= 8 || '*비밀번호는 8자리 이상입니다.',
                                    value => value.length <= 20 || '*비밀번호는 20자리 이하입니다.',
                                    value => value == this.fields.password || '*비밀번호와 비밀번호확인 다릅니다.'
                                ]"
                            ></v-text-field>
                            <v-row justify="center">
                                <v-col cols="4">
                                <v-btn color="primary" @click="clickConfirm">완료</v-btn>
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
            states: {
                checklDupl: true
            },
            fields: {
                userid: '',
                nickname: '',
                password: '',
                confirmPassword: '',
            }
        }
    },
    methods: {
        async clickConfirm() {

            const resData = await this.$axios.idDupCheck(this.fields.userid)
            this.states.checklDupl = !resData.dupl

			const { valid } = await this.$refs.form.validate()
            if( !valid ) {
                return
            }

            this.$emit('clickConfirm', {
                userid: this.fields.userid,
                nickname: this.fields.nickname,
                password: this.fields.password
            })
            
        }
    },
}
</script>
    