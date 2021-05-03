import Vue from 'vue'
import Router from 'vue-router'
import Login from '../components/Login'
import Appindex from '../components/home/Appindex'

Vue.use(Router)

export default new Router({
  mode: 'history',
  routes: [
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/index',
      name: 'AppIndex',
      component: Appindex
    }
  ]
})
