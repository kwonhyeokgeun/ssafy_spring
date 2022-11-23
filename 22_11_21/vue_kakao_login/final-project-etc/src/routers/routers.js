import Vue from "vue"; // defalut module
import VueRouter from "vue-router"; // installed module

Vue.use(VueRouter);

import MainPage from "@//components/MainPage";
import AddressSelect from "@/components/address/AddressSelect";
import AddressGrid from "@/components/address/AddressGrid";

// import MapBasic from "@/components/map/MapBasic.vue";
// import MapMarker from "@/components/map/MapMarker.vue";

import KakaoLoginJavascript from "@/components/oauth/KakaoLoginJavascript";
import KakaoLoginJavascriptBackEnd from "@/components/oauth/KakaoLoginJavascriptBackEnd";
import RegisterPage from "@/components/oauth/RegisterPage";

// import SendMail from "@/components/mail/SendMail";

import AutoCompleteFront from "@/components/ui_component/AutoCompleteFront";
import AutoCompleteBackAddress from "@/components/ui_component/AutoCompleteBackAddress";

export default new VueRouter({
  routes: [
    {
      path: "/",
      component: MainPage,
    },
    //   {
    //      path: "/login",
    //      component: KakaoLoginJavascript,
    //   },

    {
      name: "AddressSelect",
      path: "/addressSelect",
      component: AddressSelect,
    },

    {
      name: "AddressGrid",
      path: "/addressGrid",
      component: AddressGrid,
    },

    //   {
    //      name: "MapBasic",
    //      path: "/mapBasic",
    //      component: MapBasic,
    //   },
    //   {
    //      name: "MapMarker",
    //      path: "/mapMarker",
    //      component: MapMarker,
    //   },

    {
      name: "KakaoLoginJavascript",
      path: "/kakaoLoginJavascript",
      component: KakaoLoginJavascript,
    },
    {
      name: "KakaoLoginJavascriptBackEnd",
      path: "/kakaoLoginJavascriptBackEnd",
      component: KakaoLoginJavascriptBackEnd,
    },
    {
      name: "RegisterPage",
      path: "/registerPage",
      component: RegisterPage,
    },

    // {
    //   name: "SendMail",
    //   path: "/sendMail",
    //   component: SendMail,
    // },
    {
      name: "AutoCompleteFront",
      path: "/autoCompleteFront",
      component: AutoCompleteFront,
    },
    {
      name: "AutoCompleteBackAddress",
      path: "/autoCompleteBackAddress",
      component: AutoCompleteBackAddress,
    },
  ],
});
