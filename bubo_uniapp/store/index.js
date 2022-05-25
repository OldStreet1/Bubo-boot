import Vue from 'vue'
import Vuex from 'vuex'
import ES from '../euler/store/euler_store'

Vue.use(Vuex);

const store = new Vuex.Store({
    strict: process.env.NODE_ENV !== 'production',
    modules: {
        rop: ES.rop,
        user: ES.user,
        app: ES.app
    }
});

export default store
