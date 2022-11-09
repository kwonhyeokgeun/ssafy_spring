export default {
  template:
  `
    <div>
      <h4>Main 컴포넌트</h4>
      <p>안녕하세요 Vue Router를 학습하고 있습니다.</p>
      <router-view></router-view>
      <router-link to="/main/child1">첫번째</router-link>
      <router-link to="/main/child2">두번째</router-link>
    </div>
  `
}