import Vue from 'vue'
import App from './App.vue'
import router from './routers/routers.js'
import store from './store/store.js'

// for bootstrap 5
import "bootstrap/dist/css/bootstrap.min.css"
import "bootstrap"

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
  store
}).$mount('#app')

