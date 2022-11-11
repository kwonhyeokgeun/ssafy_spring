<template>
  <div class="index-container">
    <div class="index-contents">
      <div class="index-copyright-box">
        <p class="copright-text">
          Lorem Ipsum is simply dummy text of the printing and typesetting
          industry.
        </p>
      </div>
      <div class="search-select-box">
        <!-- bootstrap이나 UI 라이브러리 적용-->
        <select name="" id="" class="search-select">
          <option value="" default>시구군을 선택하세요</option>
        </select>
        <select name="" id="" class="search-select">
          <option value="" default>동을 선택하세요</option>
        </select>
      </div>
    </div>
    <!-- background 이미지 삽입을 위해서 잠깐 태그 닫음 ㅋㅋ-->
    <div class="background-box"></div>
    <div class="index-contents">
      <div class="recommand-box">
        <p class="contents-title">추천 매물</p>
        <div class="recommand-contents">
          <div class="item-box">
            <img src="../../public/assets/img/item/test.jpg" alt="" class="item-img" />
            <p class="item-title">제목</p>
            <p class="item-description">아파트아프타파느느</p>
          </div>
          <div class="item-box">
            <img src="../../public/assets/img/item/test.jpg" alt="" class="item-img" />
            <p class="item-title">제목</p>
            <p class="item-description">아파트아프타파느느</p>
          </div>
          <div class="item-box">
            <img src="../../public/assets/img/item/test.jpg" alt="" class="item-img" />
            <p class="item-title">제목</p>
            <p class="item-description">아파트아프타파느느</p>
          </div>
        </div>
      </div>
    </div>
    <div class="review-container">
      <div class="review-box">
        <p class="contents-title">거래 후기</p>
        <div class="review-contents">
          <div class="review-item-box">
            <img src="../../public/assets/img/review.png" alt="" />
            <p class="review-text">
              어린아이와 함께 저희 부부가 살 집을 구하는데, 조건에 맞는 집
              탐색부터 입주 전 하자 체크, A/S 신청에 유지 보수관리까지
              꼼꼼하게 챙겨주신 동네 매니저님 덕분에 편하게 새로운 곳에 정착할
              수 있었습니다. 필요한 가전도 계약 기간에 맞춰 유연하게 렌탈이
              가능하여 큰 부담 없이 새 집에 들어갈 수 있었어요. 집뿐 만 아니라
              아파트 커뮤니티 시설까지 먼저 살펴봐주시고 투어까지 도움 주셔서
              저희 부부에게 큰 도움이 되었습니다.
            </p>
            <span class="writer">서초동 김OO 님</span>
          </div>

          <div class="review-item-box">
            <img src="../../public/assets/img/review.png" alt="" />
            <p class="review-text">
              어린아이와 함께 저희 부부가 살 집을 구하는데, 조건에 맞는 집
              탐색부터 입주 전 하자 체크, A/S 신청에 유지 보수관리까지
              꼼꼼하게 챙겨주신 동네 매니저님 덕분에 편하게 새로운 곳에 정착할
              수 있었습니다. 필요한 가전도 계약 기간에 맞춰 유연하게 렌탈이
              가능하여 큰 부담 없이 새 집에 들어갈 수 있었어요. 집뿐 만 아니라
              아파트 커뮤니티 시설까지 먼저 살펴봐주시고 투어까지 도움 주셔서
              저희 부부에게 큰 도움이 되었습니다.
            </p>
            <span class="writer">서초동 김OO 님</span>
          </div>
        </div>
      </div>
    </div>
  </div>
</template>

<script>
  export default {
    
  }
</script>

<style scoped>
  @import "../../public/css/index.css";
</style>