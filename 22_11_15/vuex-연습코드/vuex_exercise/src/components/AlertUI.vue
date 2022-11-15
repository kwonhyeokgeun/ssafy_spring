<template>
  <div>
    <h4>Alert UI</h4>
    현재 선택된 취미는 {{ selectedHobby }} 입니다.
  </div>
</template>

<script>
export default {
  computed:{
    selectedHobby: function(){
      return this.$store.state.selectedHobby;
    }
  },
  watch:{
    selectedHobby:function(){
      alert(this.$store.state.selectedHobby)
    }
  }
}
</script>

<style>

</style>