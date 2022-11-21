<template>
  <div id="spinnerWrapper" class="d-flex justify-content-center align-items-center">
    <div class="spinner-border text-warning" role="status">
      <span class="visually-hidden">Loading...</span>
    </div>
  </div>
</template>

<script>
export default {};
</script>

<style>
#spinnerWrapper {
  position: fixed;
  top: 0;
  bottom: 0;
  left: 0;
  right: 0;
  z-index: 1;
}
</style>
