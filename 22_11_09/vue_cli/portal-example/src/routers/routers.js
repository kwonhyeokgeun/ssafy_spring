import Vue from 'vue';
import VueRouter from 'vue-router';
Vue.use(VueRouter)

import NavBar from "@/components/NavBar.vue"
import BlogPage from "@/components/BlogPage.vue"
import CafePage from "@/components/CafePage.vue"
import MailPage from "@/components/MailPage.vue"
import TellMe from "@/components/TellMe.vue"
import FooterPage from "@/components/FooterPage.vue"

export default new VueRouter({
  routes:[
    {
      path: '/',
      components: {
        NavBar:NavBar,
        default:CafePage,
        Footer:FooterPage,
      }
    },
    {
      path: '/cafe',
      components: {
        NavBar:NavBar,
        default:CafePage,
        Footer:FooterPage,
      }
    },
    {
      name:'Mail', //name속성을 줌, 이러면 path:'/mail' 대신 name:'Mail'로 가능
      path: '/mail',
      components: {
        NavBar:NavBar,
        default:MailPage,
        Footer:FooterPage,
      }
    },
    {
      path: '/blog',
      components: {
        NavBar:NavBar,
        default:BlogPage,
        Footer:FooterPage,
      }
    },
    {
      path: '/tellme',
      components: {
        NavBar:NavBar,
        default:TellMe,
        Footer:FooterPage,
      }
    },
  ]

})