import Vue from "vue"
import VueRouter from "vue-router"
import HomePage from "@/components/HomePage.vue"
import AboutPage from "@/components/AboutPage.vue"
import BoardPage from "@/components/BoardPage.vue"
import StoreWatch from "@/components/StoreWatch.vue"

Vue.use(VueRouter)

export default new VueRouter({
  routes: [
    {
      path: "/home",
      name: "Home",
      component: HomePage,
    },
    {
      path: "/about",
      name: "About",
      component: AboutPage,
    },
    {
      path: "/board",
      name: "Board",
      component: BoardPage,
    },
    {
      path: "/storeWatch",
      name: "StoreWatch",
      component: StoreWatch,
    },
  ]
})