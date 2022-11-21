<template>
  <div class="container mt-3 px-0" id="gugunGridView">
    <div class="row mx-0" v-for="(i, idx1) in rowCount" :key="idx1">
      <div
        @click="gugunSelect(addr)"
        class="col-3 p-2 text-center addr"
        v-for="(addr, idx2) in gugunList.slice((i - 1) * 4, i * 4)"
        :key="idx2"
      >
        {{ addr.name }}
      </div>
    </div>
  </div>
</template>

<script>
export default {
  computed: {
    rowCount() {
      return Math.ceil(this.gugunList.length / 4);
    },
    gugunList: {
      get() {
        return this.$store.state.address.gugunList;
      },
    },
  },
  methods: {
    gugunSelect(addr) {
      this.$emit("call-gugun-select", addr);
    },
  },
};
</script>

<style scoped>
#gugunGridView {
  position: absolute;
  top: 120px;
  left: 0;
  right: 0;

  width: 600px;
  border: 0.5px solid lightgray;
}

#gugunGridView >>> .addr {
  cursor: pointer;
}

#gugunGridView >>> .addr:hover {
  background-color: dodgerblue;
  color: white;
}
</style>
