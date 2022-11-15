import Vue from "vue"
import Vuex from "vuex"

Vue.use(Vuex)

export default new Vuex.Store({
  state:{
    message : 'vuex',
    count:5,
    board:{
      limit:10,
      offset:0,
      searchWord:'',
    },
    hobbyList:[],
    selectedHobby:'',
  },

  //위의 state를 바꾸는 유일한 방법
  mutations:{
    SET_MESSAGE(state, message){
      state.message = message
    },
    SET_COUNT(state, count){
      state.count = count
    },
    SET_BOARD(state, payload){
      state.board.limit = payload.limit
      state.board.offset = payload.offset
      state.board.searchWord = payload.searchWord
    },
    SET_STORE(state, payload){
      state.count = payload.count
      state.message = payload.message
    },
    SET_HOBBY_LIST(state, payload){
      state.hobbyList = payload
    }
  },

  //필요한 기능/동작수행/ 수행결과물을 state에 반영하기 위한 메소드집합, 반영할때 mutations을 이용
  //backend 요청/결과 처리 코드는 Component에 따라서 component자체에 있을 수도 있고, vuex store에 있을 수도 잇다.
  actions:{
    //비동기면 async 붙이기
    setMessage(context, message){   
      context.commit('SET_MESSAGE',message)
    },
    setCount(context, count){
      context.commit('SET_COUNT',count)
    },
    setBoard(context, payload){
      context.commit('SET_BOARD',payload)
    },
    setStore(context, payload){
      context.commit('SET_STORE',payload)
    },
    setHobbyList(context, payload){
      context.commit('SET_HOBBY_LIST',payload)
    }
  },

  //저장소인 state의 값을 외부에 노출시키는 방법
  //그대로 또는 state의 데이터의 변형을 처리한 후 결과를 return
  getters:{
    getReversedMessage: function(state){
      return state.message.split('').reverse().join('');
    },
    isCountEven:function(state){
      return (state.count%2 ==0) ? '짝수' : '홀수'
    },
    getBoardInfo(state){
      return state.board
    }
  },
})