<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
    <div class="container-fluid">
      <a class="navbar-brand" href="#">Navbar</a>
      <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item">
            <router-link to="/cafe" class="nav-link">cafe</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/blog" class="nav-link">blog</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/mail" class="nav-link">mail</router-link>
          </li>
          <li class="nav-item">
            <router-link to="/tellme" class="nav-link">tellme</router-link>
          </li>
          
        </ul>
        <form class="d-flex">
          <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search" v-model="searchWord">
          <button class="btn btn-outline-success" @click="search">Search</button>
        </form>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  data() {
    return {
      searchWord:''
    }
  },
  methods: {
    search(){
      alert(this.searchWord)
    }
  },
}
</script>

<style scoped>

</style>