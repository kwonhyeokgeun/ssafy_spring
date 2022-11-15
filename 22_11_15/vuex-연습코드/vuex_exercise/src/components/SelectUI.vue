<template>
  <div>
    <h4>Select UI</h4>
    <select v-model="$store.state.selectedHobby">
      <option v-for="(item, index) in $store.state.hobbyList" :key="index" v-bind:value="item.value">
        {{ item.name }}
      </option>
    </select>
  </div>
</template>

<script>
export default {
  created(){
    let hobbyList=[
      {name:'Drink', value:'DRK'},
      {name:'Camping', value:'CAM'},
      {name:'FootBall', value:'FBA'},
    ]
    this.$store.dispatch('setHobbyList',hobbyList)
  }
}
</script>

<style>

</style>