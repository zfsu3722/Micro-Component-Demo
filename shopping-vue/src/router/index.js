import Vue from 'vue'
import Router from 'vue-router'
import Login from '../views/Login'
import Main from '../views/Main'
import Goods from '@/views/onlineshopping/Goods'
import ShoppingCart from '@/views/onlineshopping/ShoppingCart'

Vue.use(Router)
export default new Router({
  mode:'history',
  routes: [
    {
      path: '/',
      redirect: '/login'
    },
    {
      path: '/login',
      name: 'Login',
      component:Login
    },
    {
      path: '/main',
      name: 'Main',
      component: Main,
      props: true,
      children:[
        {
          path: '/',
          redirect: '/main/goods'
        },
     {
        path: '/main/ShoppingCart',
        name: 'ShoppingCart',
        component: ShoppingCart
      },
      {
        path:'/main/goods',
        name:'Goods',
        component: Goods
      },
    ]
  },
    {
      path:'/goHome',
      redirect:'/main'
    }
  ]
});
