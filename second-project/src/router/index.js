import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/about',
    name: 'About',
    component: () => import('../views/About.vue')
  },
  {
    path: '/alert',
    name: 'Alert',
    component: () => import('../views/Alert.vue')
  },
  {
    path: '/avatar',
    name: 'Avatar',
    component: () => import('../views/Avatar.vue')
  },
  {
    path: '/badge',
    name: 'Badge',
    component: () => import('../views/Badge.vue')
  },
  {
    path: '/breadcrumb',
    name: 'Breadcrumb',
    component: () => import('../views/Breadcrumb.vue')
  },
  {
    path: '/button',
    name: 'Button',
    component: () => import('../views/Button.vue')
  },
  {
    path: '/calendar',
    name: 'Calendar',
    component: () => import('../views/Calendar.vue')
  },
  {
    path: '/card',
    name: 'Card',
    component: () => import('../views/Card.vue')
  },
  {
    path: '/form',
    name: 'Form',
    component: () => import('../views/Form.vue')
  },
  {
    path: '/jumbotron',
    name: 'Jumbotron',
    component: () => import('../views/Jumbotron.vue')
  },
  {
    path: '/modal',
    name: 'Modal',
    component: () => import('../views/Modal.vue')
  },
  {
    path: '/nav',
    name: 'Nav',
    component: () => import('../views/Nav.vue')
  },
  {
    path: '/navbar',
    name: 'Navbar',
    component: () => import('../views/Navbar.vue')
  },
  {
    path: '/pagination',
    name: 'Pagination',
    component: () => import('../views/Pagination.vue')
  },
  {
    path: '/popover',
    name: 'Popover',
    component: () => import('../views/Popover.vue')
  },
  {
    path: '/preference',
    name: 'Preference',
    component: () => import('../views/Preference.vue')
  }
]

const router = new VueRouter({
  routes
})

export default router
