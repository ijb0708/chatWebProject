import loginView from '@/views/loginView.vue'
import registerView from '@/views/registerView.vue'

const users = {
  path: '/users',
  children: [
    {
      path: 'login',
      name: 'login',
      component: loginView,
    },
    {
      path: 'register',
      name: 'register',
      component: registerView,
    }
  ],
}
export default users