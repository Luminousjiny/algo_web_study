import Vue from 'vue';
import Vuex from 'vuex';
import axios from 'axios';

Vue.use(Vuex);

export default new Vuex.Store({
    // 컴포넌트들이 공유할 데이터 지정
    // 여기선 굳이 필요없을거같은데 연습할겸 영화 목록만 저장
    state: {
        items: [],
    },
    getters: {
        items: function(state){
            return state.items;
        }
    },
    mutations: {
        setMovieList: function(state, payload){
            state.items = payload;
        }
    },
    actions: {
        getMovieList: function(context){
            axios.get('http://localhost:8097/movieboard/api/movies?page=1')
                .then((response) => {
                    context.commit('setMovieList', response.data.movieList);
                })
                .catch((error) => {
                    console.log(error);
                    console.log("vuex 영화 목록 불러오는 중 에러 발생");
                })
        }
    }
});