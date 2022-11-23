<template>
  <div class="mb-3">
    <label for="searchWord" class="form-label">검색어</label>
    <input type="text" class="form-control" id="searchWord" v-model="searchWord" @keyup="autoComplete" />
    <div id="result"  v-show="searchResult.length > 0" v-bind:class="{ border: isBorder }">
      <ul>
        <li v-for="(item, index) in searchResult" :key="index" @click="userSelect(item)">{{item}}</li>
      </ul>
    </div>
  </div>
</template>


<script>
export default {
  data() {
    return {
      list: ["apple", "apple watch", "apple macbook", "apple macbook pro", "iphone", "iphone 12"],
      searchResult: [],
      searchWord: "",

      // class boolean
      isBorder: false,
    };
  },
  methods: {
    autoComplete() {
      if (this.searchWord == "") {
        this.isBorder = false;
        this.searchResult = [];
        return;
      }

      let reg = new RegExp(this.searchWord);
      this.searchResult = this.list.filter((term) => (term.match(reg) ? term : ""));
      this.isBorder = true;
    },
    userSelect(item){
      alert(item);
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