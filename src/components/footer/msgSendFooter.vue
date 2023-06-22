<template>
    <v-footer app >
        <v-container class="ma-0 pa-0" >
            <v-row no-gutters>
                <v-col>
                    <div class="d-flex flex-row align-center">
                        <v-text-field 
                            v-model="this.fields.message" 
                            placeholder="Type Something" 
                            @keypress.enter="clickSend"
                        ></v-text-field>
                        <v-btn icon class="ml-4" @click="clickSend"><v-icon>mdi-send</v-icon></v-btn>
                    </div>
                </v-col>
            </v-row>
        </v-container>
    </v-footer>
</template>

<script>
export default {
    name: 'msgFooter',
	data() {
		return {
		    fields: {
				message: '',
			}
		};
	},
	methods: {
		clickSend() {
            this.$emit('clickSend', this.fields.message)
            this.fields.message=''
		}
	},
}
</script>