import Vue from 'vue'
import Router from 'vue-router'
import Home from './views/HomePage'

Vue.use(Router)

export default new Router({
  //激活路由的样式定义
  linkActiveClass: "active",
  routes: [
    {
      path: '/',
      name: 'home',
      component: Home,
      meta:{
        showBot: true
      },
    },
    {
      path: '/about',
      name: 'about',
      meta:{
        showBot: true
      },
      component: () => import('./views/AboutPage.vue')
    }
  ]
})
