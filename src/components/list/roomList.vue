<template>
    <v-card
      class="mx-auto"
    >
      <v-list>
        <template v-if="list.length === 0">
            <v-list-item>
                생성되어 있는 방이 없습니다.
            </v-list-item>
        </template>
        <template v-else>
            <v-list-subheader inset>Rooms</v-list-subheader>
            <v-list-item 
                v-for="(item, idx) in list" 
                :key="idx"
                :title="item.room_name"
                color="primary"
                @click="clickEnterRoom(item.room_seq)"
            >
                <template v-slot:prepend>
                    <v-avatar>
                        <v-icon>mdi-door</v-icon>
                    </v-avatar>
                </template>
                
                <!-- <template v-slot:subtitle>
                    admin: {{ room. }}
                </template> -->

                <template v-slot:append>
                    <v-btn
                        color="grey-lighten-1"
                        icon="mdi-delete"
                        variant="text"
                        @click.stop="clickDeleteRoom(item.room_seq)"
                    ></v-btn>
                </template>
            </v-list-item>
        </template>
      </v-list>
    </v-card>
</template>
    
<script>
export default {
    name: 'roomList',
    props: {
        list: {
            type: Array,
            default: []
        }
    },
    methods: {
        clickEnterRoom(room_seq) {
            this.$emit('clickEnterRoom', room_seq)
        },
        clickDeleteRoom(room_seq) {
            this.$emit('clickDeleteRoom', room_seq)
        }
    }
}
</script>

<style>
.highlight {
  transition: opacity 0.5s;
}

.highlight:active {
  opacity: 0.5;
}

</style>