import home from '@/views/Home.vue'
import loginView from '@/views/loginView.vue'

const test = {
  path: '/test',
  children: [
    {
      path: 'home',
      name: 'home',
      component: home,
    },
    {
      path: 'test',
      name: 'homeTest',
      component: loginView,
    }
  ],
}
export default test