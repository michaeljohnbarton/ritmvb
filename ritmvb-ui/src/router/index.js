/*
  File:         index.js
  Author:       Auto-generated, Michael Barton
  Description:  Contains all of the routing information for the different views.
*/

import Vue from 'vue'
import VueRouter from 'vue-router'

Vue.use(VueRouter)

  const routes = [
  {
    path: '/',
    name: 'Home',
    component: () => import('../views/Home.vue')
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import('../views/About.vue')
  },
  {
    path: '/schedule',
    name: 'Schedule',
    component: () => import('../views/Schedule.vue')
  },
  {
    path: '/roster',
    name: 'Roster',
    component: () => import('../views/Roster.vue')
  },
  {
    path: '/contactUs',
    name: 'Contact Us',
    component: () => import('../views/ContactUs.vue')
  },
]

const router = new VueRouter({
  routes,
  scrollBehavior() {
    return { x: 0, y: 0 }
  }
})

export default router
