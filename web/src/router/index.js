import { createRouter, createWebHashHistory } from 'vue-router'
import DefaultLayout from '../views/layouts/DefaultLayout'
import AdminLayout from '../views/layouts/AdminLayout'
import ControlView from '../views/ControlView'
import LoginView from '../views/LoginView'
import Explore from '../views/user/Explore'
import Contest from '../views/user/Contest'
import Problem from '../views/user/Problem'
import SubmitRecord from '../views/user/SubmitRecord'
import Dashboard from '../views/admin/Dashboard'
import UserTable from '../views/admin/UserTable'

const routes = [
  {
    path: '/',
    name: 'Control',
    component: ControlView
  },
  {
    path: '/login',
    name: 'Login',
    component: LoginView
  },
  {
    path: '/explore',
    name: 'User',
    component: DefaultLayout,
    children: [
      {
        path: '',
        name: 'Explore',
        component: Explore,
      },
      {
        path: 'contest/:id',
        name: 'Contest',
        component: Contest,
      },
      {
        path: 'problem/:id',
        name: 'Problem',
        component: Problem,
      },
      {
        path: 'submit',
        name: 'Submit',
        component: SubmitRecord,
      }
    ]
  },
  {
    path: '/admin',
    name: 'Admin',
    component: AdminLayout,
    redirect: { name: 'Dashboard' },
    children: [
      {
        path: 'dashboard',
        name: 'Dashboard',
        component: Dashboard,
      },
      {
        path: 'users',
        name: 'UserTable',
        component: UserTable,
      }
    ]
  },

  // {
  //   path: '/about',
  //   name: 'About',
  //   // route level code-splitting
  //   // this generates a separate chunk (about.[hash].js) for this route
  //   // which is lazy-loaded when the route is visited.
  //   component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  // }
]

const router = createRouter({
  history: createWebHashHistory(),
  routes
})

export default router
