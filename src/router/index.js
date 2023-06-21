// Composables
import { createRouter, createWebHistory } from 'vue-router'
import test from '@/router/test'
import users from '@/router/users'
import rooms from './rooms'

const routes = [
  // {
  //   path: '/',
  //   component: home,
  //   // children: [
  //   //   {
  //   //     path: '',
  //   //     name: 'Home',
  //   //     component: () => import(/* webpackChunkName: "home" */ '@/views/Home.vue'),
  //   //   },
  //   // ],
  // },
  test,
  users,
  rooms
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
