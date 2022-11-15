import Vue from "vue"; // defalut module
import VueRouter from "vue-router"; // installed module

Vue.use(VueRouter);

import BoardMain from "@/components/BoardMain.vue";
import Login from "@/components/LoginPage.vue";

import Register from "@/components/RegisterPage.vue";
import store from "@/store/store.js";

// /, /board 요청 시 login check 하고 route 시킨다.
// 그렇지 않으면 BoardMain 경우 살짝 게시판이 보였다가 로그인으로 이동하게 됨
export default new VueRouter({
   routes: [
      {
         path: "/",
         component: BoardMain,
         beforeEnter: (to, from, next) => {
            if (!store.state.login.isLogin) {
               next("/login");
            } else {
               return next();
            }
         },
      },

      {
         name: "BoardMain",
         path: "/board",
         component: BoardMain,
         beforeEnter: (to, from, next) => {
            console.log(store.state.login.isLogin);
            if (!store.state.login.isLogin) {
               next("/login");
            } else {
               return next();
            }
         },
      },

      {
         name: "Login",
         path: "/login",
         component: Login,
      },

      {
         name: "Register",
         path: "/register",
         component: Register,
      },
   ],
});
