<template>
  <!-- 모두 store 를 사용하도록 변경 -->

  <nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
    <div class="container">
      <router-link to="/" class="navbar-brand">FinalProjectETC</router-link>
      <button
        class="navbar-toggler"
        type="button"
        data-bs-toggle="collapse"
        data-bs-target="#navbarSupportedContent"
        aria-controls="navbarSupportedContent"
        aria-expanded="false"
        aria-label="Toggle navigation"
      >
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav me-auto mb-2 mb-lg-0">
          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              주소
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li>
                <router-link to="/addressSelect" class="dropdown-item">주소 select</router-link>
              </li>
              <li><router-link to="/addressGrid" class="dropdown-item">주소 Grid</router-link></li>
            </ul>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Map
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li>
                <router-link to="/mapBasic" class="dropdown-item">카카오지도 기본</router-link>
              </li>
              <li>
                <router-link to="/mapMarker" class="dropdown-item">카카오지도 Marker</router-link>
              </li>
            </ul>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              O-Auth
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li>
                <router-link to="/kakaoLoginJavascript" class="dropdown-item"
                  >카카오 로그인 javascript</router-link
                >
              </li>
              <li>
                <router-link to="/kakaoLoginJavascriptBackEnd" class="dropdown-item"
                  >카카오 로그인 javascript BackEnd</router-link
                >
              </li>
            </ul>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              Mail
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li><router-link to="/sendMail" class="dropdown-item">Send Mail</router-link></li>
            </ul>
          </li>

          <li class="nav-item dropdown">
            <a
              class="nav-link dropdown-toggle"
              href="#"
              id="navbarDropdown"
              role="button"
              data-bs-toggle="dropdown"
              aria-expanded="false"
            >
              UI Component
            </a>
            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
              <li>
                <router-link to="/autoCompleteFront" class="dropdown-item"
                  >Auto Complete Front</router-link
                >
              </li>
              <li>
                <router-link to="/autoCompleteBackAddress" class="dropdown-item"
                  >Auto Complete Back Address</router-link
                >
              </li>
            </ul>
          </li>
        </ul>
      </div>
    </div>
  </nav>
</template>

<script>
export default {
  name: "NavBar",
  methods: {},
  mounted() {
    // 주의 if( Kakao == undefined ) 는 오류 발생 typeof 필요
    // typeof Kakao 는 string "undefined" 를 return
    // if (typeof Kakao !== undefined) return; 은 문법 오류는 아니나, Kakao 가 is not defuned 발생
    /* global Kakao */
    if (typeof Kakao !== "undefined") return;

    const script = document.createElement("script");

    script.onload = () => Kakao.init(process.env.VUE_APP_KAKAO_JAVASCRIPT_KEY);
    script.src = "https://developers.kakao.com/sdk/js/kakao.js";
    document.head.appendChild(script);
  },
};
</script>

<style></style>
