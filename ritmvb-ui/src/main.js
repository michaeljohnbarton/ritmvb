/*
  File:         main.js
  Author:       Auto-generated
  Description:  The main entry point of the Vue instance for the site
*/

import Vue from 'vue'
import App from './App.vue'
import router from './router'
import vuetify from './plugins/vuetify';

Vue.config.productionTip = false

new Vue({
  router,
  vuetify,
  render: h => h(App)
}).$mount('#app')

export const serverURL = "http://localhost:8080"