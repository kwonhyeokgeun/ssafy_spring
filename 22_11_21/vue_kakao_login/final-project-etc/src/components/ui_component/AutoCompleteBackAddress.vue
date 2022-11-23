<template>
  <div class="mb-3">
    <label for="searchWord" class="form-label">검색어</label>
    <input type="text" class="form-control" id="searchWord" v-model="searchWord" @input="autoComplete" />
    <div id="result"  v-show="searchResult.length > 0" v-bind:class="{ border: isBorder }">
      <ul>
        <li v-for="(item, index) in searchResult" :key="index" @click="userSelect(item)">
          {{item.sidoName}} {{item.gugunName}} {{ item.name }}
        </li>
      </ul>
    </div>
  </div>
</template>


<script>
import http from "@/common/axios.js";

export default {
  data() {
    return {
      searchResult: [],
      searchWord: "",

      // class boolean
      isBorder: false,
    };
  },
  methods: {
    async autoComplete() {
      if (this.searchWord == "") {
        this.isBorder = false;
        this.searchResult = [];
        return;
      }
console.log(this.searchWord)
// get with params <= backend @RequestBody X <= query string

      let { data } = await http.get("/searchDong", { params: { searchWord: this.searchWord } } );
      console.log(data);
      this.searchResult = data;
      this.isBorder = true;
    },
    userSelect(item){
      alert(item.code);
      console.log(item.name)
    }
  },
};
</script>


<style>
#result {
  margin-top: 3px;
  padding: 3px;
}
#result ul {
  list-style-type: none;
  padding: 0;
  margin: 0;
}
#result ul li {
  padding: 5px 0;
}
#result ul li:hover {
  background: #eee;
  cursor: pointer;
}

.border {
  border: 1px solid #ccc;
}
</style>

