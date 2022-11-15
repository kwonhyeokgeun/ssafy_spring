<template>
  <div>
    <nav-bar v-bind:isLogin="isLogin" v-bind:userInfo="userInfo"></nav-bar> <!-- login 여부에따라 UI 변경 -->
    <router-view v-on:call-parent-loginSuccess=loginSuccess></router-view> <!-- loginPage 또는 BoardMain 컴포넌트가 렌더링  -->
  </div>
</template>

<script>

import NavBar from './components/NavBar.vue'

export default {
  name: 'App',
  components:{
    NavBar,
  },
  data(){
    return{
      isLogin:false,
      userInfo:{},
    }
  },
  methods:{
    loginSuccess(userInfo){
      this.isLogin=true;
      this.userInfo = userInfo;
    }
  }
}
</script>

<style>

</style>
