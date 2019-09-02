<template>
  <div class="home" ref="homeContent">
    <div class="home_bg">
      <div class="home_blue">
        <div class="home_main">
          <div>
            <img src="../../public/img/loginPage/login_phone.png" alt />
            <input type="text" class="" placeholder="手机号" />
          </div>
          <div>
            <img src="../../public/img/loginPage/login_pass.png" alt />
            <input type="text" class="" placeholder="验证码"   />
          </div>
        </div>
      </div>
    </div>
  </div>
</template>
<script>
import BScroll from 'better-scroll'
import bottomBar from '../components/BottomBar'
export default {
  components: {},
  methods: {
    initScroll() {
      if (this.$sc) {
        this.$sc.refresh()
      } else {
        // 因为BS本身问题，直接在mounted构建无法读取DOM元素
        // 在 构建对象时 使用 40ms 延迟
        setTimeout(() => {
          this.$sc = new BScroll(this.$refs.homeContent, {
            click: true
          })
        }, 40)
      }
    }
  },
  beforeRouteEnter(to, from, next) {
    next(vm => vm.initScroll())
  },
  mounted() {
    this.initScroll()
  }
}
</script>
<style lang="less" scoped>
.home {
  width: 100%;
  height: 100vh;
  box-sizing: border-box;
  .home_bg {
    width: 100%;
    height: 100%;
    // background-size: cover;
    background-image: url('../../public/img/loginPage/login.png');
    background-repeat: no-repeat;
    background-size: 100%;
    background-position: center center;
    margin: 0 auto;
    position: relative;
    .home_blue {
      width: 21.2rem;
      background: #576fe4;
      border-radius: 0.26667rem;
      border: 0.01333rem solid #576fe4;
      margin: 20rem auto;
      margin-left: 1rem;
      position: absolute;
      .home_main {
        width: 20.66667rem;
        height: 15.6rem;
        background: #ffffff;
        border-radius: 0.26667rem;
        margin: 0.35rem auto;
        div {
          width: 19.4rem;
          height: 3.4rem;
          border-bottom: 0.01333rem solid #ccc;
          margin: 0 auto;
          margin-top: 1rem;
          img {
            width: 2rem;
            margin-top: 1rem;
          }
        }
      }
    }
  }
}
</style>
