<template>
  <div class="container">
    <button @click="loginWithKakao" class="btn btn-primary">Kakao 로그인 Javascript</button>
  </div>
</template>

<script>
import http from "@/common/axios.js";

// CORS 이슈는 없다. Kakao 에서 response
// Access-Control-Allow-Methods: GET, POST, PUT, DELETE, OPTIONS
// Access-Control-Allow-Origin: *
export default {
  methods: {
    loginWithKakao() {
      var $this = this;

      Kakao.Auth.login({
        success: function (authObj) {
          // access_token 등 데이터가 전달된다.
          // 백엔드에 access_token 을 전달하고 user info 를 받는 방식이라면 authObj 의 access_token 을 이용한다.
          // https://developers.kakao.com/sdk/reference/js/release/Kakao.Auth.html#AuthSuccessCallback
          // 이 코드는 javascript 로 user info 를 받는 방식으로 처리한다.
          console.log("----1");
          console.log(authObj);

          // 인증을 거치고 나서 개인 프로파일 정보를 얻어온다. /v2/user/me
          Kakao.API.request({
            url: "/v2/user/me",
            success: async function (response) {
              if (Kakao.Auth.getAccessToken()) {
                console.log("----2");
                console.log(response);
                // 카카오 이메일로 회원 가입 여부 확인 후 회원이 아닌 경우는 메세지와 함께 회원 가입 페이지로 이동
                if (!response.kakao_account.has_email || !response.kakao_account.is_email_valid) {
                  alert("kakao 인증 이메일이 없거나, 유효하지 않습니다.");
                  return;
                } else {
                  // 이미 가입한 회원
                  // async, await 필수!!
                  let result = await $this.isRegisteredUser(response.kakao_account.email);
                  console.log("----3");
                  console.log(result);
                  if (result) {
                    $this.$store.commit("SET_LOGIN", {
                      isLogin: true,
                      userName: response.properties.nickname,
                      userProfileImageUrl: response.properties.thumbnail_image,
                    });
                  } else {
                    // 가입하지 않은 회원
                    alert("kakao 인증되었으나, 회원 가입이 필요합니다.");
                    let params = {
                      userName: response.properties.nickname,
                      userEmail: response.kakao_account.email,
                    };
                    
                    $this.$router.push({ name: "RegisterPage", params }); // params : params
                  }
                }
              }
            },
            fail: function (error) {
              console.log("----4");
              console.log(error);
            },
          });
        },
        fail: function (error) {
          console.err("----------");
          console.error(error);
        },
      });
    },
    async isRegisteredUser(email) {
      console.log(2);
      console.log(email);
      try {
        let { data } = await http.get(`/isRegisteredUser?email=${email}`);
        console.warn(data);
        console.warn(data.result);
        if (data.result == "registered") return true;
        else return false;
      } catch (error) {
        console.log(error);
      }
    },
  },
  mounted() {
    /* global Kakao */
    if (typeof Kakao != undefined) return;

    const script = document.createElement("script");

    script.onload = () => Kakao.init(process.env.VUE_APP_KAKAO_JAVASCRIPT_KEY);
    script.src = "https://developers.kakao.com/sdk/js/kakao.js";
    document.head.appendChild(script);
  },
  computed: {},
  watch: {},
};
</script>

<style></style>
