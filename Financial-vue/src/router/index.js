import Vue from 'vue';
import Router from 'vue-router';
import Main from '../views/Main';
import Login from '../views/Login';
// import UserList from '../views/user/List';
// import UserProfile from '../views/user/Profile';
import NotFound from '../views/NotFound';

// import UserEditFinancial from '../views/financial/EditFinancial';
import RefundItemList from '@/views/financial/RefundItemList';
import ReimbursementList from '../views/financial/ReimbursementList'

Vue.use(Router);


export default new Router({
  mode:'history',
  routes:[
    {
      path: '/',
      redirect: '/main'
    },
    
    {
      path: '/main',
      component:Main,
      props:true,
      children:[
        
        {path:'/financial/RefundItemList', name:'RefundItemList', component:RefundItemList},
      {
        path:'/financial/ReimbursementList',
        name:'ReimbursementList',
        component:ReimbursementList,
      },
        // {path:'/user/profile',
        // name:'UserProfile',
        // component:UserProfile,
        // props:true},
        // {path:'/user/list',component:UserList},
       
        // {path:'/financial/editfinancial',component:UserEditFinancial},
      
      ]
    },{
      path: '/login',
      component:Login
    },{
      path:'/goHome',
      redirect:'/main'
    },{
      path:'*',
      component:NotFound
    },
  ]
});
