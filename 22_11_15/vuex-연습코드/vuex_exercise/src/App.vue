<template>
  <div>
    <div id="nav">
      <router-link to="/home">Home</router-link> | 
      <router-link to="/about">About</router-link> | 
      <router-link to="/board">Board</router-link> | 
      <router-link to="/storeWatch">StoreWatch</router-link> | 
    </div>
    <router-view></router-view>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>