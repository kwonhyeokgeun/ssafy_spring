<template>
  <div>
    <router-view name="NavBar"></router-view>  
    <router-view name="default"></router-view>
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

</style>
