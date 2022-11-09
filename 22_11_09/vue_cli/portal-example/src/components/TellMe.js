export default{
  template:`
  <div class="mt-3">
    <div id="editor"></div>
    <button type="button" class="btn btn-primary" @click="sendTellMe">Send</button>
  </div>
  `,
  data() {
    return {
      CKEditor:null,

    }
  },
  async mounted() {
    this.CKEditor = await ClassicEditor.create(document.querySelector('#editor'));

  },
  methods: {
    sendTellMe: function(){
      let message = this.CKEditor.getData();
      alert(message)
    }
  },
}