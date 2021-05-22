import Vue from 'vue'
import VueRouter from 'vue-router'
import LoginPage from '../views/LoginPage'
import StuLayout from '../views/StuLayout.vue'
import AdminLayout from '../views/AdminLayout'

import ExamList from '@/components/ExamList'
import ExamDetail from '@/components/ExamDetail'
import SubmissionList from '@/components/SubmissionList'
import ProblemDetail from '@/components/ProblemDetail'
import UserProfile from '@/components/UserProfile'

import UserListAdmin from '@/components/admin/UserList'
import ExamListAdmin from '@/components/admin/ExamList'
import ExamDetailAdmin from '@/components/admin/ExamDetail'
import ProblemCreate from '@/components/admin/ProblemCreate'
import FileListAdmin from '@/components/admin/FileList'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    redirect: '/exam',
    name: 'Index',
    component: StuLayout,
    children: [
      {
        path: '/exam',
        component: ExamList
      },
      {
        path: '/exam/:id',
        component: ExamDetail,
        name: 'examDetail'

      },
      {
        path: '/submission',
        component: SubmissionList
      },
      {
        path: '/problem/:id',
        component: ProblemDetail,
        name: 'problemDetail'
      }
    ]
  },
  {
    path: '/login',
    component: LoginPage
  },
  {
    path: '/admin',
    name: 'Dashboard',
    component: AdminLayout,
    redirect: '/admin/user',
    beforeEnter: (to, from, next) => {
      if (localStorage.role == 1) {
        next()
      } else {
        next('/')
      }
    },
    children: [
      {
        path: 'user',
        component: UserListAdmin
      },
      {
        path: 'exam',
        component: ExamListAdmin
      },
      {
        path: 'exam/:id',
        component: ExamDetailAdmin,
        name: 'examAnalysis'
      },
      {
        path: 'problem',
        component: ProblemCreate
      },
      {
        path: 'resource',
        component: FileListAdmin
      }
    ]
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }
]

const router = new VueRouter({
  mode: 'hash',
  base: process.env.BASE_URL,
  routes
})

export default router
