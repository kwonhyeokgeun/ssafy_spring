<template>
  <nav class="navbar navbar-expand-lg navbar-light bg-light">
      <div class="container">
          <a class="navbar-brand" href="#">
            <img src="../assets/noProfile.png" style="width: 24px; height: 24px; border-radius: 50%;">{{userInfo.userName}}</a>
          <button class="navbar-toggler" type="button" data-bs-toggle="collapse"
              data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false"
              aria-label="Toggle navigation">
              <span class="navbar-toggler-icon"></span>
          </button>
          <div class="collapse navbar-collapse" id="navbarSupportedContent">
              <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                  <li class="nav-item">
                      <!--<a class="nav-link active" aria-current="page" href="#">Home</a>-->
                      <router-link v-show="isLogin" class="nav-link" to="/board" >Board</router-link> <!--isLogin이 true면 보임-->
                  </li>

                  <li class="nav-item">
                      <router-link v-show="isLogin" class="nav-link" to="/board" >My Page</router-link> <!--isLogin이 true면 보임-->
                  </li>
                  <li class="nav-item">
                      <a class="nav-link" href="#">Link</a>
                  </li>
              </ul>
              <ul class="navbar-nav">
                  <li class="nav-item">
                      <a class="nav-link" id="btnLogout" href="#">Logout</a>
                  </li>
              </ul>
          </div>
      </div>
  </nav>
</template>

<script>
export default {
  props:['isLogin','userInfo']
}
</script>

<style>

</style>