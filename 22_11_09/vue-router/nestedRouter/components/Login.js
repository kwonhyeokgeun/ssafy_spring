export default {
  template: `
  <div>
    <div class="mb-3">
      <label for="userId" class="form-label">아이디 입력</label>
      <input type="text" class="form-control" id="userId" v-model="userId" placeholder="name@example.com">
    </div>
    <div class="mb-3">
      <label for="password" class="form-label">비밀번호 입력</label>
      <input type="text" class="form-control" id="password" v-model="password" placeholder="****">
    </div>
    <button @click="login" type="button" class="btn btn-primary">login</button>
  </div>
  `,
  data:function () {
    return{
      userId:'',
      password:'',
    }
  },
  methods: {
    login(){
      alert(this.userId+ " "+ this.password)
    }
  },
};
