// Composables
import { createRouter, createWebHistory } from 'vue-router'
import home from '@/views/Home.vue'
import test from '@/router/test'
import users from '@/router/users'

const routes = [
  {
    path: '/',
    component: home,
    // children: [
    //   {
    //     path: '',
    //     name: 'Home',
    //     component: () => import(/* webpackChunkName: "home" */ '@/views/Home.vue'),
    //   },
    // ],
  },
  test,
  users
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
})

export default router
