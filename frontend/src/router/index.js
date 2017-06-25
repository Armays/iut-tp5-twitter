import Vue from 'vue'
import Router from 'vue-router'
import Hello from '@/components/Hello'
import Timeline from '@/components/Timeline'
import Feed from '@/components/Feed'
Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Hello',
      component: Hello
    },
    {
      path: '/timeline',
      name: 'timeline',
      component: Timeline
    }
  ]
})
