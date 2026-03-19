<template>
    <v-footer app color="primary">
        <v-container class="ma-0 pa-0">
            <v-form @submit="handleSubmit" ref="form">
                <v-row no-gutters>
                    <v-col>
                        <div class="d-flex flex-row align-center">
                            <v-text-field 
                                v-model="this.fields.roomname" 
                                placeholder="Type Room name" 
                                :rules="[
                                    value => this.states.roomname || Boolean(value) || '방이름을 적어주세요'
                                ]"
                                @keypress.enter="clickCreateRoom"
                                @input="this.states.roomname=false"
                            ></v-text-field>
                            <v-btn icon class="ml-4" @click="clickCreateRoom">
                                <v-icon>mdi-home</v-icon>
                            </v-btn>
                        </div>
                    </v-col>
                </v-row>
            </v-form>
        </v-container>
    </v-footer>
</template>

<script>
export default {
    name: 'createRoomFooter',
	data() {
		return {
            states: {
                roomname: false
            },
		    fields: {
				roomname: '',
			}
		};
	},
	methods: {
		clickCreateRoom() {
            this.states.roomname = false
            if( !this.$refs.form.validate() ) {
                return
            }
            this.$emit('clickCreateRoom', this.fields.roomname)
            this.states.roomname = true
            this.fields.roomname = ''
		},
        handleSubmit(event) {
            event.preventDefault();
            clickCreateRoom()
        }
	},
}
</script>