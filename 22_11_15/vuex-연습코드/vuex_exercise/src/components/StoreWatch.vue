<template>
  <div>
    <h4>Store Watch</h4>
    <SelectUI></SelectUI>
    <AlertUI></AlertUI>

  </div>
</template>

<script>
import SelectUI from "@/components/SelectUI.vue"
import AlertUI from "@/components/AlertUI.vue"


export default {
  components:{ SelectUI, AlertUI },
}
</script>

<style>

</style>