export default{
  template:`
  <div class="card mt-3" >
    <img src="https://picsum.photos/1024/400/?image=25" class="card-img-top" alt="...">
    <div class="card-body">
      <h5 class="card-title">Mail</h5>
      <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
      <a href="#" class="btn btn-primary" @click="checkMail">check Mail</a>
    </div>
  </div>
  `,
  data() {
    return {
      from: this.$route.query.from,
      content: this.$route.query.content
    }
  },

  methods: {
    checkMail:function(){
      if(this.from){
        alert(this.from + ' '+this.content)
      }else{
        alert("메일이 없습니다")
      }
    }
  },
}