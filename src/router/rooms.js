import roomListView from '@/views/roomListView.vue'
import chatView from '@/views/chatView.vue'

const rooms = {
    path: '/rooms',
    children: [
        {
            path: 'list',
            name: 'roomlist',
            component: roomListView,
        },
        {
            path: 'chat',
            name: 'chat',
            component: chatView,
        }
    ],
}

export default rooms