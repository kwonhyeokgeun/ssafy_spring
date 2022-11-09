<template>
  <div class="container">

    <router-view name="NavBar"></router-view>  
    <router-view></router-view>
    <router-view name="Footer"></router-view>

  </div>
</template>

<script>
  export default {
    name: 'App',
    components: {
      
    }
  }
</script>

<style>
  /*bootstrap cdn import*/
  @import url(https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css);
</style>
