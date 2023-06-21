<template>
    <v-card
      class="mx-auto"
    >
      <v-list>
        <template v-if="roomList.length === 0">
            <v-list-item>
                생성되어 있는 방이 없습니다.
            </v-list-item>
        </template>
        <template v-else>
            <v-list-subheader inset>Rooms</v-list-subheader>
            <v-list-item 
                v-for="(room, idx) in roomList" 
                :key="idx"
                :title="room.name"
                color="primary"
                @click="clickEnterRoom(room.room_seq)"
            >
                <template v-slot:prepend>
                    <v-avatar>
                        <v-icon>mdi-door</v-icon>
                    </v-avatar>
                </template>
                
                <!-- <template v-slot:subtitle>
                    test
                </template> -->

                <template v-slot:append>
                    <v-btn
                        color="grey-lighten-1"
                        icon="mdi-delete"
                        variant="text"
                        @click.stop="clickDeleteRoom(room.room_seq)"
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
        roomList: {
            type: Array,
            default: []
        }
    },
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