<template>
    <!-- Modal Insert-->
    <div class="modal fade" id="boardInsertModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog modal-lg">
      <div class="modal-content">
        <div class="modal-header">
          <h5 class="modal-title" id="exampleModalLabel">글 쓰기</h5>
          <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
        </div>
        <div class="modal-body">            
            <div class="mb-3">
                <label for="titleInsert" class="form-label">제목</label>
                <input type="text" class="form-control" id="titleInsert">
              </div>
              <div class="mb-3">
                <label for="contentInsert" class="form-label">내용</label>
                <!-- CKEditor insert -->
                <div id="divEditorInsert"></div>
              </div>
              <div class="mb-3">
              	<div class="form-check">
	  <input class="form-check-input" type="checkbox" value="" id="chkFileUploadInsert">
	  <label class="form-check-label" for="chkFileUploadInsert">파일 추가</label>
	</div>
              </div>
              <div class="mb-3" style="display: none;" id="imgFileUploadInsertWrapper">
              	<input type="file" id="inputFileUploadInsert" multiple>
              	<div id="imgFileUploadInsertThumbnail" class="thumbnail-wrapper"></div>
              </div>
              <button id="btnBoardInsert" type="button" class="btn btn-sm btn-primary float-end">등록</button>
        </div>            
      </div>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style>

</style>