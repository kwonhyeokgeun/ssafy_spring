<template>
  <div class="container mt-3">
    <div id="editor"></div>
    <button type="button" class="btn btn-primary" @click="sendTellMe">Send</button>
  </div>
</template>

<script>
//CKEditor를 cdn방식이 아닌 npm 방식으로 사용 => import
//CKEditor를 import해서 vue와 연결
import Vue from "vue";
import CKEditor from "@ckeditor/ckeditor5-vue2"
import ClassicEditor from "@ckeditor/ckeditor5-build-classic"

Vue.use(CKEditor)

export default {
   data() {
    return {
      CKEditor:null,

    }
  },
  methods: {
    sendTellMe: function(){
      let message = this.CKEditor.getData();
      alert(message)
    }
  },
  async mounted() {
    this.CKEditor = await ClassicEditor.create(document.querySelector('#editor'));

  },
}
</script>

<style scoped>
  .container >>> .ck-editor__editable {
    height: 200px;
  }
</style>