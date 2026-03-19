import loginView from '@/views/loginView.vue'

const test = {
  path: '/test',
  children: [
    {
      path: 'test',
      name: 'homeTest',
      component: loginView,
    }
  ],
}
export default test