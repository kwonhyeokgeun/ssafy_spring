<template>
  <div class="container mt-3 px-0" id="dongGridView">
    <div class="row mx-0" v-for="(i, idx1) in rowCount" :key="idx1">
      <div
        @click="dongSelect(addr)"
        class="col-3 p-2 text-center addr"
        v-for="(addr, idx2) in dongList.slice((i - 1) * 4, i * 4)"
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
      return Math.ceil(this.dongList.length / 4);
    },
    dongList: {
      get() {
        return this.$store.state.address.dongList;
      },
    },
  },
  methods: {
    dongSelect(addr) {
      this.$emit("call-dong-select", addr);
    },
  },
};
</script>

<style scoped>
#dongGridView {
  position: absolute;
  top: 120px;
  left: 0;
  right: 0;

  width: 600px;
  border: 0.5px solid lightgray;
}

#dongGridView >>> .addr {
  cursor: pointer;
}

#dongGridView >>> .addr:hover {
  background-color: dodgerblue;
  color: white;
}
</style>
