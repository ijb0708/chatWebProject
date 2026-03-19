import customAxios from '@/api/axiosInit'
// store/modules/auth.js

export default {
    namespaced: true,
    state :{
        token: null,
    },
    getters: {
        isAuth: state => Boolean(state.token),
    },
    mutations: {
        SET_TOKEN(state, token) {
            state.token = token;
        },
        RESET(state) {
            state.token = null;
        },
    },
    actions: {
        setToken({ commit }, token) {
            // this.$axios.defaults.headers.common['Authorization'] = `Bearer ${token}`
            customAxios.defaults.headers.common['Authorization'] = `Bearer ${token}`;
            commit('SET_TOKEN', token);
        },
        resetToken({ commit }) {
            // this.$axios.defaults.headers.common['Authorization'] = ''
            customAxios.defaults.headers.common['Authorization'] = '';
            commit('RESET');
        },
    },
    watch: {

    }
}