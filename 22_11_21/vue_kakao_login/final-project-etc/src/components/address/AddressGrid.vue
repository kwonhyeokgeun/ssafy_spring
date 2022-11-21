<template>
  <div>
    <div class="row justify-content-center" id="addressGrid">
      <div class="col-12 d-flex justify-content-center">
        <button
          @click="clickSidoButton"
          type="button"
          class="btn mx-3"
          :class="{ 'btn-success': sidoSelected, 'btn-light': !sidoSelected }"
        >
          {{ sidoLabel }}
        </button>
        <button
          @click="clickGugunButton"
          type="button"
          class="btn mx-3"
          :class="{ 'btn-success': gugunSelected, 'btn-light': !gugunSelected }"
        >
          {{ gugunLabel }}
        </button>
        <button
          @click="clickDongButton"
          type="button"
          class="btn mx-3"
          :class="{ 'btn-success': dongSelected, 'btn-light': !dongSelected }"
        >
          {{ dongLabel }}
        </button>
      </div>
    </div>
    <sido-grid v-show="showSidoGrid" v-on:call-sido-select="sidoSelect"></sido-grid>
    <gugun-grid
      v-show="showGugunGrid && sidoSelected"
      v-on:call-gugun-select="gugunSelect"
    ></gugun-grid>
    <dong-grid
      v-show="showDongGrid && gugunSelected"
      v-on:call-dong-select="dongSelect"
    ></dong-grid>
  </div>
</template>

<script>
// import GridUI from '@/components/address/GridUI.vue';
import SidoGrid from "./SidoGrid.vue";
import GugunGrid from "./GugunGrid.vue";
import DongGrid from "./DongGrid.vue";

export default {
  components: { SidoGrid, GugunGrid, DongGrid },
  data() {
    return {
      showSidoGrid: false,
      showGugunGrid: false,
      showDongGrid: false,

      sidoLabel: "시/도",
      gugunLabel: "구/군",
      dongLabel: "읍/면/동",
    };
  },
  methods: {
    clickSidoButton() {
      if (this.showSidoGrid) {
        this.showSidoGrid = false;
      } else {
        this.showSidoGrid = true;
        this.showGugunGrid = false;
        this.showDongGrid = false;
      }
    },
    clickGugunButton() {
      if (this.showGugunGrid) {
        this.showGugunGrid = false;
      } else {
        this.showGugunGrid = true;
        this.showSidoGrid = false;
        this.showDongGrid = false;
      }
    },
    clickDongButton() {
      if (this.showDongGrid) {
        this.showDongGrid = false;
      } else {
        this.showDongGrid = true;
        this.showSidoGrid = false;
        this.showGugunGrid = false;
      }
    },
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
    sidoSelect(addr) {
      this.$store.commit("SET_ADDRESS_SIDO", addr.code);
      this.getGugunList();
      this.showSidoGrid = false;
      this.showGugunGrid = true;

      this.sidoLabel = addr.name;
      this.gugunLabel = "구/군";
      this.dongLabel = "읍/면/동";
    },
    gugunSelect(addr) {
      this.$store.commit("SET_ADDRESS_GUGUN", addr.code);
      this.getDongList();
      this.showGugunGrid = false;
      this.showDongGrid = true;

      this.gugunLabel = addr.name;
      this.dongLabel = "읍/면/동";
    },
    dongSelect(addr) {
      this.$store.commit("SET_ADDRESS_DONG", addr.code);
      //this.getDongList();
      this.showDongGrid = false;

      this.dongLabel = addr.name;
      alert(addr.code);
    },
  },
  created() {
    this.getSidoList();
  },
  computed: {
    sidoSelected() {
      return this.$store.state.address.sido != "0";
    },
    gugunSelected() {
      return this.$store.state.address.gugun != "0";
    },
    dongSelected() {
      return this.$store.state.address.dong != "0";
    },
  },
};
</script>

<style scoped>
/* #addressGrid >>> .btn {
  width: 500px;
} */
</style>
