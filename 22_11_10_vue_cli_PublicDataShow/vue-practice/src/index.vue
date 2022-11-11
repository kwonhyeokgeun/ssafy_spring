<template>
  <div>
    <nav-bar></nav-bar>
    <main-page></main-page>
    <footer-page></footer-page>
  </div>
</template>

<script>
import FooterPage from '@/components/FooterPage.vue'
import MainPage from '@/components/MainPage.vue'
import NavBar from '@/components/NavBar.vue'


export default {
  name: 'App',
  components: {
    FooterPage,
    MainPage,
    NavBar
  }
}
</script>

<style>

</style>
