
import { createRouter, createWebHistory, RouteRecordRaw } from 'vue-router';
import HomeView from '../views/HomeView.vue';

const routes: Array<RouteRecordRaw> = [
  {
    path: '/',
    name: 'home',
    component: HomeView,
    redirect:"main",
    children:[
      {
        path: '/main',
        name: 'main',
        meta:{
          isShow:true,
          title:"首页"
        },
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "main" */ '../views/MainView.vue'),
      },
      {
        path: '/search',
        name: 'search',
        meta:{
          isShow:true,
          title:"搜索"
        },
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "main1" */ '../views/Main1View.vue'),
      },
      {
        path: '/order',
        name: 'orderHome',
        meta:{
          isShow:true,
          title:"订单"
        },
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import(/* webpackChunkName: "order" */ '../views/OrderView.vue'),
      },
      {
        path: '/particulars/:id',
        name: 'particulars',
        meta:{
          isShow:false,
          title:"main"
        },
        component: () => import(/* webpackChunkName: "particulars" */ '../views/ParticularsView.vue'),
      },
      {
        path: '/about',
        name: 'about',
        meta:{
          isShow:false,
          title:"main"
        },
        component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue'),
     },
     {
      path: '/settlement',
      name: 'settlement',
      component: () => import(/* webpackChunkName: "settlement" */ '../views/SettlementView.vue'),
    },
  ]
  },
  {
    path: '/login',
    name: 'login',
    component: () => import(/* webpackChunkName: "login" */ '../views/LoginView.vue'),
  }, 
  {
    path: '/register',
    name: 'register',
    component: () => import(/* webpackChunkName: "register" */ '../views/RegisterView.vue')
  },
 
  {
    path: '/backstage',
    name: 'backstage',
    component: () => import(/* webpackChunkName: "backstage" */ '../views/backstage/IndexView.vue'),
    children:[
      {
        path: '/order1',
        name: 'order1',
        meta:{
          backstage:true,
          title:"电影管理"
        },
        component: () => import(/* webpackChunkName: "order" */ '../views/backstage/OrderView.vue'),
      }, 
      {
        path: '/session',
        name: 'session',
        meta:{
          backstage:true,
          title:"场次管理"
        },
        component: () => import(/* webpackChunkName: "session" */ '../views/backstage/SessionView.vue'),
      },
      {
        path: '/user',
        name: 'user',
        meta:{
          backstage:true,
          title:"用户管理"
        },
        component: () => import(/* webpackChunkName: "order" */ '../views/backstage/UserView.vue'),
      },
      {
        path: '/order2',
        name: 'order2',
        meta:{
          backstage:true,
          title:"订单管理"
        },
        component: () => import(/* webpackChunkName: "order1" */ '../views/backstage/OrderView1.vue'),
      }, 
    ]
  }
]

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes
})


router.beforeEach((to, from, next) => {
  const token: string | null = localStorage.getItem("token")
  if(!token && (to.path !== "/login") &&  to.path !== "/register"){
    next("/login")
  }
  else{
    next()
  }
})

export default router
