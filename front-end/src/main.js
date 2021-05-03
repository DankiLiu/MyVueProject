// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'
import Element from 'element-ui'
import store from './store'

import axios from 'axios'

// var axios = require('axios')
// axios.default.baseURL = 'http://localhost:8443/api'

axios.defaults.baseURL = 'http://localhost:8443/api'

// Vue.prototype.$axios = axios.get('http://localhost:8443/api')
Vue.prototype.$axios = axios
Vue.config.productionTip = false

Vue.use(Element)

router.beforeEach((to, from, next) => {
  if (to.meta.requireAuth) {
    if (store.state.user.username) {
      next()
    } else {
      next({
        path: 'login',
        query: {redirect: to.fullPath}
      })
    }
  } else {
    next()
  }
}
)

/* eslint-disable no-new */
new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})
