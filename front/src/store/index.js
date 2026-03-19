// store/index.js
import Vuex from 'vuex';
import auth from './modules/auth.js';

export default new Vuex.Store({
    modules: {
        auth:auth
    },
});