import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios';
import store from './store';

Vue.config.productionTip = false
Vue.use(router);
Vue.use(ElementUI);
Vue.use(axios);

new Vue({
  el: '#app',
  router,
  store,
  render: h => h(App)
})
