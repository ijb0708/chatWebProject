// Composables
import { createRouter, createWebHistory } from 'vue-router'
import test from '@/router/test'
import users from '@/router/users'
import rooms from '@/router/rooms'

import loginView from '@/views/loginView.vue'

const routes = [
  {
    path: '/',
    component: loginView
  },
  // test,
  users,
  rooms
]

const router = createRouter({
  history: createWebHistory(import.meta.env.VITE_BASE_URL),
  routes,
})

export default router
