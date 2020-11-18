<template>
    <div id="movie-detail">
        <table id="movie-detail-table">
            <tr>
                <th>영화 번호</th>
                <td>{{movie.mno}}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td>{{movie.mtitle}}</td>
            </tr>
            <tr>
                <th>개봉일</th>
                <td>{{movie.mdate}}</td>
            </tr>
            <tr>
                <th>감독</th>
                <td>{{movie.mdirector}}</td>
            </tr>
            <tr>
                <th>줄거리</th>
                <td><textarea name="mcontent" id="mcontent" cols="30" rows="10" v-model="movie.mcontent" readonly></textarea></td>
            </tr>
        </table>
        <button @click="updateMovie">수정</button>
        <button @click="deleteMovie">삭제</button>

        <review v-bind:propsmno="mno"></review>
    </div>
</template>

<script>
import axios from 'axios';
import Review from '../components/Review.vue';

export default {
    data: function(){
        return {
            mno: 0,
            movie: {}
        };
    },
    created() {
        var vm = this;
        vm.mno = parseInt(vm.$route.params.mno);
        axios.get('http://localhost:8097/movieboard/api/movies/' + vm.mno)
            .then((response) => {
                vm.movie = response.data;
            })
            .catch((ex) => {
                console.log("movie detail get error : " + ex);
            })
    },
    methods: {
        deleteMovie : function(){
            axios.delete('http://localhost:8097/movieboard/api/movies/' + this.mno)
            .then((response) => {
                var result = response.data;
                console.log(response.data);
                if(result == "success"){
                    alert("삭제 성공");
                } else {
                    alert("삭제 실패");
                }
                this.$router.push({
                    path: '/movies/list'
                })
            })
        },
        updateMovie: function(){
            this.$router.push({
                name: 'MovieUpdate',
                params : {
                    movie: this.movie
                }
            })
        }
    },
    components : {
        Review
    }
}
</script>

<style>
    #movie-detail-table {
        margin: auto;
    }
</style>