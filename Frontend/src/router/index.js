import { createRouter, createWebHistory } from 'vue-router'
import HomeView from '../views/HomeView.vue'
import ShipmentView from '../views/ShipmentView.vue'
import DropoffView from '../views/DropoffView.vue'
import EODView from '../views/EODView.vue'
import TrackView from '../views/TrackView.vue'
import Login from '../components/Login.vue'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/home',
      name: 'home',
      component: HomeView
    },
    {
      path: '/about',
      name: 'about',
      // route level code-splitting
      // this generates a separate chunk (About.[hash].js) for this route
      // which is lazy-loaded when the route is visited.
      component: () => import('../views/AboutView.vue')
    },
    {
      path: '/shipment',
      name:'shipment',
      component: ShipmentView
    },
    {
      path: '/dropoff',
      name:'dropoff',
      component: DropoffView
    },
    {
      path: '/track',
      name:'Tracking',
      component: TrackView
    },
    {
      path: '/eod',
      name:'End of the Day',
      component: EODView
    },
    {
      path: '/',
      name:'Login',
      component: Login
    }
  ]
})

export default router
