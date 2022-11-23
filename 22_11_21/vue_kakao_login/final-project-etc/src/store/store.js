import Vue from "vue";
import Vuex from "vuex";

Vue.use(Vuex);

import http from "@/common/axios.js";

export default new Vuex.Store({
  state: {
    address: {
      sidoList: [],
      sido: "0", // 최초 선택 항목 지정
      gugunList: [],
      gugun: "0",
      dongList: [],
      dong: "0",
    },

    // login, NavBar
    login: {
      // NavBar
      isLogin: false,

      userName: "",
      userProfileImageUrl: "",

      // Login
      userEmail: "dskim@my.com",
      userPassword: "1234",
    },
  },
  // state 상태를 변경하는 유일한 방법
  mutations: {
    SET_ADDRESS_SIDOlIST(state, payload) {
      state.address.sidoList = payload;
      // state.address.currentList = state.address.sidoList;
      // state.address.currentAddress = "S";
    },
    SET_ADDRESS_GUGUNlIST(state, payload) {
      state.address.gugunList = payload;
      // state.address.currentList = state.address.gugunList;
      // state.address.currentAddress = "G";
    },
    SET_ADDRESS_DONGlIST(state, payload) {
      state.address.dongList = payload;
      // state.address.currentList = state.address.dongList;
      // state.address.currentAddress = "D";
    },

    SET_ADDRESS_SIDO(state, payload) {
      state.address.sido = payload;

      state.address.gugun = "0";
      state.address.dong = "0";
      state.address.gugunList = [];
      state.address.dongList = [];
    },
    SET_ADDRESS_GUGUN(state, payload) {
      state.address.gugun = payload;

      state.address.dong = "0";
      state.address.dongList = [];
    },
    SET_ADDRESS_DONG(state, payload) {
      state.address.dong = payload;
    },

    SET_LOGIN(state, payload) {
      state.login.isLogin = payload.isLogin;
      state.login.userName = payload.userName;
      state.login.userProfileImageUrl = payload.userProfileImageUrl;
    },
  },
  // for async method
  actions: {
    async getSidoList(context) {
      try {
        let { data } = await http.get("/sidos");
        context.commit("SET_ADDRESS_SIDOlIST", data);
        console.log(data);
      } catch (error) {
        console.log(error);
      }
    },
    async getGugunList(context) {
      try {
        let { data } = await http.get("/guguns/" + this.state.address.sido);
        console.log(data);
        context.commit("SET_ADDRESS_GUGUNlIST", data);
      } catch (error) {
        console.log(error);
      }
    },
    async getDongList(context) {
      try {
        let { data } = await http.get("/dongs/" + this.state.address.gugun);
        console.log(data);
        context.commit("SET_ADDRESS_DONGlIST", data);
      } catch (error) {
        console.log(error);
      }
    },
  },
  getters: {
    getSidoList(state) {
      return state.address.sidoList;
    },
    getGugunList(state) {
      return state.address.gugunList;
    },
    getDongList(state) {
      return state.address.dongList;
    },

    getSido(state) {
      return state.address.sido;
    },
    getGugun(state) {
      return state.address.gugun;
    },
    getDong(state) {
      return state.address.dong;
    },
  },
});
