<template>
  <div id="app">
    <img src="./assets/logo.png">
    <p>
        <router-link to="/timeline">Go to Timeline</router-link>
    </p>
    <router-view></router-view>
  </div>
</template>

<script>
import Timeline from '@/components/Timeline';
import Vue from 'vue';
import VueRouter from 'vue-router';

export default {
  name: 'app'
}

const routes = [
  { path: '/timeline', component: Timeline }
]

const router = new VueRouter({
  routes // short for routes: routes
})

const app = new Vue({
  router
}).$mount('#app')
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
