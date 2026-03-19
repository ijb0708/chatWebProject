<template>
    <v-dialog v-model="dialogShow" persistent max-width="400">
      <v-card>
        <v-card-text>
            {{ message }}
        </v-card-text>
        <v-card-actions>
          <v-btn color="primary" block @click="this.dialogShow = false">Close Dialog</v-btn>
        </v-card-actions>
      </v-card>
    </v-dialog>
</template>

<script>
export default {
    name: 'infoPopup',
    props: {
        isShow: {
            type: Boolean,
            default: false
        },
        message: {
            type: String,
            default: false
        }
    },
    data() {
        return {
            dialogShow: true
        }
    }
}
</script>
