<template>
  <div class="card mt-3" >
    <img src="https://picsum.photos/1024/400/?image=41" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Cafe</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="#" class="btn btn-primary" @click="sendMail">Send Mail</a>
    </div>
  </div>
</template>

<script>
  import router from "../routers/routers.js"

  export default{
  
    methods: {
      sendMail(){
        let data={
          from: 'hong@gildong.com',
          content: '안녕하세요? 홍길동입니다!'
        }
        //router를 이용해서 main Component로 전송
        router.push({
          path:'/mail', query:data
        })
      }
    },
  }
</script>

<style scoped>

</style>