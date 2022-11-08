//javascript를 내보내는 역할



/////export named
// 여러개를 내보낼 때 유리
// 가져다 쓰는 쪽에서는 내보내는 이름과 동일한 이름을 사용해야 한다.

/*
let PLAYERS = ["손흥민", "이강인", "이승우"] //배열
const MAX_SIZE = 1000;
function add(n1, n2) {
  return n1 + n2;
}

var obj={
  template: `<div>My Template</div>`,
  data(){
    return {
      num: 20
    }
  }
}
export {PLAYERS, MAX_SIZE, add, obj};
*/


/////export default
// 기본 내보내기는 하나만 가능
// 가져다 쓰는 쪽에서는 어떤 이름이라도 사용이 가능

// class, function을 제외한 항목은 이름을 export default할 수 없다.
// type export default X <- 문법적인 오류
// name export default X <- 가져다 쓰는쪽에서 마음대로 이름을 지정해서 쓸수 없다.
//export default MAX_SIZE=1000;

//export default 1000;

export default{
  template:``,
  data(){
    return{
      num:20
    }
  },
  log: function(){
    console.log("log is called!")
  },
  add(n1,n2){
    return n1+n2;
  }
}

