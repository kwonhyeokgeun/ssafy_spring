<template>
  <div>
    <nav-bar />
    <router-view class="container"></router-view>
    <spinnerUI v-if="isLoading"></spinnerUI>
    <!-- {{ isLoading }} -->
  </div>
</template>

<script>
import NavBar from "./components/NavBar.vue";
import http from "./common/axios";
// spinner
import SpinnerUI from "./components/ui_component/SpinnerUI.vue";

export default {
  name: "App",
  data() {
    return {
      isLoading: false,
    };
  },
  components: {
    NavBar,
    SpinnerUI,
  },
  // spinner
  created() {
    http.interceptors.request.use(
      (config) => {
        this.isLoading = true;
        return config;
      },
      (error) => {
        this.isLoading = false;
        return Promise.reject(error);
      }
    );

    http.interceptors.response.use(
      (response) => {
        this.isLoading = false;
        return response;
      },
      (error) => {
        this.isLoading = false;
        return Promise.reject(error);
      }
    );
  },
};
</script>

<style></style>
