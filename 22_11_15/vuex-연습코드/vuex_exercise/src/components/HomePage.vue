<template>
  <div>
    <h4>Home Page</h4>
    <hr>
    <h4>from data</h4>
    {{ message }} {{count}}

    <hr>
    <h4>from store state</h4>
    {{ $store.state.message }} {{$store.state.count}}

    <hr>
    <h4>from store getters</h4>
    {{ $store.getters.getReversedMessage }} {{ $store.getters.isCountEven }}

    <hr>
    <h4>from store getters - mapGetters</h4>
    {{ getReversedMessage }} {{ checkCountIsEven }}

    <hr>
    <home-sub></home-sub>
  </div>
  
</template>

<script>
import HomeSub from'@/components/HomeSub.vue'
import { mapGetters } from 'vuex'

export default {
  components:{ HomeSub },
  data(){
    return{
      message: 'Hello SSAFY!',
      count: this.$store.state.count
    }
  },
  computed:{
    ...mapGetters(['getReversedMessage']), //this.$store.getters.getReversedMessage와 같음
    ...mapGetters({checkCountIsEven: 'isCountEven'}) //store의 isCountEven을 checkCountIsEven이름으로 가져오기
  }
}
</script>

<style>

</style>