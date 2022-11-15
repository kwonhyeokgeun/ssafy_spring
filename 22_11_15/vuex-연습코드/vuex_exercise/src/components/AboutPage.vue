<template>
  <div>
    <h4>About Page</h4>
    Home에서 바뀐게 여기서도 적용됨(store변수라서)
    <hr>
    <h4>from data</h4>
    {{ message }} {{count}}

    <hr>
    <h4>from store state</h4>
    {{ $store.state.message }} {{$store.state.count}}

    <hr>
    <h4>from store getters</h4>
    {{ $store.getters.getReversedMessage }} {{ $store.getters.isCountEven }}


    
  </div>
</template>

<script>
export default {
  data(){
    return{
      message: 'Hello SSAFY!',
      count: this.$store.state.count
    }
  }
}
</script>

<style>

</style>