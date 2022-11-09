import Vue from 'vue'
import App from './App.vue'

//router import
import router from './routers/routers.js'

Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router,
}).$mount('#app')
