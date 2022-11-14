<template>
  <div class="container">
    <h4 class="text-center mt-3">게시판</h4>

    <div class="input-group mb-3 mt-3">
      <input
        type="text"
        class="form-control"
        placeholder="Search"
        v-model="searchWord"
        @keydown.enter="boardList"
      />
      <button class="btn btn-success" type="button" @click="boardList">
        Search
      </button>
    </div>

    <table class="table table-hover">
      <thead>
        <tr>
          <th scope="col">#</th>
          <th scope="col">작성자</th>
          <th scope="col">제목</th>
          <th scope="col">작성일자</th>
          <th scope="col">조회수</th>
        </tr>
      </thead>
      <tbody id="boardTbody">
        <tr v-for="(board, index) in list" :key="index" style="cursor: pointer">
          <td>{{ board.boardId }}</td>
          <td>{{ board.userName }}</td>
          <td>{{ board.title }}</td>
          <td>{{ board.regDt.date | makeDateStr(".") }}</td>
          <td>{{ board.readCount }}</td>
        </tr>
      </tbody>
    </table>

    <!-- pagination component, 4개의 props필요 -->
    <PaginationUI
      v-bind:listRowCount="listRowCount"
      v-bind:totalListItemCount="totalListItemCount"
      v-bind:pageLinkCount="pageLinkCount"
      v-bind:currentPageIndex="currentPageIndex"
      v-on:call-parent-move-page="movePage"
    >
    </PaginationUI>
    <button class="btn btn-primary" type="button" @click="showInsertModal">
      글쓰기
    </button>
    <insert-modal v-on:call-parent-insert="closeAfterInsert"></insert-modal>
  </div>
</template>

<script>
import http from "@/common/axios";
import util from "@/common/util.js"  //util.js import
import PaginationUI from './PaginationUI.vue';

import InsertModal from "./modals/InsertModal.vue" //vue 컴포넌트
import {Modal} from "bootstrap"; //vue 컴포넌트에서 bootstrap modal을 사용하기 위함

export default {
  components: { PaginationUI, InsertModal },
  data() {
    return {
      limit: 10,
      offset: 0,
      searchWord: "",
      list: [],

      totalListItemCount: 0,
      listRowCount: 10, //한페이지에 보여줄갯수
      pageLinkCount: 10, //한번에보여줄 페이지 버튼수
      currentPageIndex: 1,

      //modal
      insertModal: null, //bootstrap modal객체 할당(ui 컴포넌트를 전달)
    };
  },
  methods: {
    async boardList() {
      //limit, offset, searchWord 필요
      let params = {
        limit: this.limit,
        offset: this.offset,
        searchWord: this.searchWord,
      };

      try {
        let response = await http.get("/boards", {
          params,
        });

        let { data } = response;
        console.log(data);
        if (data.reslt == "login") {
          //세션 타임아웃
          this.$router.push("/login");
        } else {
          this.list = data.list;
          this.totalListItemCount = data.count;
        }
      } catch (error) {
        console.error(error);
        this.$alertify.error("서버에 문제가 생겼습니다.");
      }
    },
    movePage(pageIndex) {
      this.offset = (pageIndex - 1) * this.listRowCount;
      this.currentPageIndex = pageIndex;
      this.boardList();
    },
    showInsertModal() {
      this.insertModal.show();
    },
    closeAfterInsert() {
      this.insertModal.hide();
      this.boardList();
    },
  },
  created: function () {
    this.boardList();
  },
  mounted() {
    //insertModal에 객체(insetModal.vue에서)를 가져와 할당해줌
    this.insertModal = new Modal(document.querySelector("#insertModal"));
  },
  filters: {
    makeDateStr: function (date, type) {
      return util.makeDateStr(date.year, date.month, date.day, type);
    },
  },
};
</script>

<style></style>