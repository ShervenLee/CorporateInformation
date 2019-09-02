<template>
  <div id="app" ref="app">
    <!-- 底部 -->
    <bottom-bar v-show="$route.meta.showBot"></bottom-bar>
    <router-view />
  </div>
</template>

<script>
import BottomBar from './components/BottomBar'
export default {
  components: {
    BottomBar
  }
}
</script>

 
<style lang="less">
*:not(.swiper-wrapper) {
  padding: 0px;
  margin: 0px;
  overflow: hidden;
}
// #app {
//   position: absolute;
//   top: 0px;
//   bottom: 0px;
//   left: 0px;
//   right: 0px;
//   // max-width: 750px;
//   margin: 0 auto;
//   background-color: white;
// }
</style>