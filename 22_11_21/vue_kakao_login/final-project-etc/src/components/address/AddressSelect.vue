<template>
  <div class="row align-items-center justify-content-center">
    <div class="col-3">
      <label for="sido">시/도</label>
      <!-- 
            만약, 시/도를 선택하세요 을 빼고 첫 번째 option 을 선택하도록 할 경우
            아래 코드는 안된다. :selected="index==0" 가 제대로 작동 X
            
            <option v-for="(option, index) in selectOptionList" :selected="index==0"
                v-bind:key="index" v-bind:value="option.value" >{{ option.text }}</option>

            대신 v-model 에 첫 번째 option 의 value 를 지정해 준다.
        -->
      <select class="form-select" id="sido" v-model="sido">
        <option value="0">시/도를 선택하세요.</option>
        <option v-for="(sido, index) in sidoList" :key="index" :value="sido.code">
          {{ sido.name }}
        </option>
      </select>
    </div>
    <div class="col-3">
      <label for="gugun">구/군</label>
      <select class="form-select" id="gugun" v-model="gugun">
        <option value="0">구/군을 선택하세요.</option>
        <option v-for="(gugun, index) in gugunList" :key="index" :value="gugun.code">
          {{ gugun.name }}
        </option>
      </select>
    </div>
    <div class="col-3">
      <label for="dong">읍/면/동</label>
      <select class="form-select d-inline" id="dong" v-model="dong">
        <option value="0">읍/면/동을 선택하세요.</option>
        <option v-for="(dong, index) in dongList" :key="index" :value="dong.code">
          {{ dong.name }}
        </option>
      </select>
    </div>
  </div>
</template>

<script>
export default {
  methods: {
    getSidoList() {
      this.$store.dispatch("getSidoList");
    },
    getGugunList() {
      this.$store.dispatch("getGugunList");
    },
    getDongList() {
      this.$store.dispatch("getDongList");
    },
    getHouseDealList() {
      console.log(this.$store.state.address.dong);
    },
  },
  created() {
    this.getSidoList();
  },
  computed: {
    sidoList() {
      return this.$store.getters.getSidoList;
    },
    gugunList() {
      return this.$store.getters.getGugunList;
    },
    dongList() {
      return this.$store.getters.getDongList;
    },
    sido: {
      get() {
        return this.$store.state.address.sido;
      },
      set(sido) {
        this.$store.commit("SET_ADDRESS_SIDO", sido);
      },
    },
    gugun: {
      get() {
        return this.$store.state.address.gugun;
      },
      set(gugun) {
        this.$store.commit("SET_ADDRESS_GUGUN", gugun);
      },
    },
    dong: {
      get() {
        return this.$store.state.address.dong;
      },
      set(dong) {
        this.$store.commit("SET_ADDRESS_DONG", dong);
      },
    },
  },
  watch: {
    sido: function () {
      console.log("watch : sido() " + this.sido);
      if (this.sido != "0") this.getGugunList();
    },
    gugun: function () {
      console.log("watch : gugun() " + this.gugun);
      if (this.gugun != "0") this.getDongList();
    },
    dong: function () {
      console.log("watch : dong() " + this.dong);
      this.getHouseDealList();
    },
  },
};
</script>

<style></style>
