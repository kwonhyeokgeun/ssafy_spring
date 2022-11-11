<template>


  <div class="container">
    <h4 class="text-center mt-3">게시판</h4>

    <div class="input-group mb-3  mt-3">
        <input type="text" class="form-control"  placeholder="Search" v-model="searchWord" @keydown.enter="boardList"/>
        <button class="btn btn-success" type="button" @click="boardList">Search</button>
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
          <tr v-for="(board, index) in list" :key="index" style="cursor:pointer">
            <td>{{board.boardId}}</td>
            <td>{{board.userName}}</td>
            <td>{{board.title}}</td>
            <td>{{board.regDt.date | makeDateStr('.')}}</td>
            <td>{{board.readCount}}</td>
          </tr>           
        </tbody>
      </table>

      <!-- pagination component, 4개의 props필요 -->
      <PaginationUI v-bind:listRowCount="listRowCount" 
        v-bind:totalListItemCount="totalListItemCount" 
        v-bind:pageLinkCount="pageLinkCount" 
        v-bind:currentPageIndex="currentPageIndex"
        v-on:call-parent-move-page="movePage" >
      </PaginationUI>

      <button class="btn btn-primary" type="button" id="btnInsertPage">글쓰기</button>
  </div>
</template>

<script>
import http from "@/common/axios";
import util from "@/common/util.js"  //util.js import
import PaginationUI from './PaginationUI.vue';

export default {
  components: { PaginationUI },
  data(){
    return{
      limit:10,
      offset:0,
      searchWord:'',
      list:[],

      totalListItemCount:0,
      listRowCount:10, //한페이지에 보여줄갯수
      pageLinkCount:10, //한번에보여줄 페이지 버튼수
      currentPageIndex:1,
    }
  },
  methods:{
    async boardList(){
      //limit, offset, searchWord 필요
      let params = {
        limit:this.limit,
        offset:this.offset,
        searchWord:this.searchWord,
      }

      try {
        let response = await http.get("/boards", {
          params
        });

        let { data } = response;
        console.log(data);
        if(data.reslt =='login') { //세션 타임아웃
          this.$router.push('/login')
        }else{
          this.list=data.list
          this.totalListItemCount = data.count
        }
      } catch (error) {
        console.error(error);
        this.$alertify.error("서버에 문제가 생겼습니다.");
        
      }
    },
    movePage(pageIndex){
      this.offset =(pageIndex-1)*this.listRowCount;
      this.currentPageIndex = pageIndex;
      this.boardList();
    }
  },
  created: function(){
    this.boardList();
  },
  filters:{
    makeDateStr : function(date, type){
      return util.makeDateStr(date.year, date.month, date.day, type)
    }
  }
}
</script>

<style>

</style>