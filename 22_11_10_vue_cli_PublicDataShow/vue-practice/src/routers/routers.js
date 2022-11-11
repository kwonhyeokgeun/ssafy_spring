import Vue from 'vue';
import VueRouter from 'vue-router';
Vue.use(VueRouter)

import FooterPage from '@/components/FooterPage.vue'
import MainPage from '@/components/MainPage.vue'
import NavBar from '@/components/NavBar.vue'
import BodyContainer from '@/components/BodyContainer.vue'

export default new VueRouter({
  routes:[
    {
      path: '/',
      components: {
        NavBar:NavBar,
        default:MainPage,
        Footer:FooterPage,
      }
    },
    {
      name:'deal',
      path: '/deal',
      components: {
        NavBar:NavBar,
        default:BodyContainer,
        Footer:FooterPage,
      }
    },
    
  ]

})