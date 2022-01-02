import Vue from 'vue'
import Vuex from 'vuex'
 
Vue.use(Vuex)
 
const store = new Vuex.Store({
  state: {
    currentUser: ''
  },
  mutations: {
    setCurrentUser: (state, payload) => {
      state.currentUser = payload;
    }
  },
  getters: {
    getCurrentUser: (state) => {
      return state.currentUser
    } 
  }
});

export default store
