<template>
    <div id="movie-list">
        <table id="movie-list-table">
            <tr>
                <th>제목</th>
                <th>감독</th>
                <th>개봉일</th>
            </tr>
            <tr v-for="movie in movies" :key="movie.mno">
                <td><router-link :to="'/movies/' + movie.mno">{{movie.mtitle}}</router-link></td>
                <td>{{ movie.mdirector }}</td>
                <td>{{ movie.mdate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data : function(){
        return {
            movies : []
        };
    },
    created(){
        var vm = this;
        axios.get('http://localhost:8097/movieboard/api/movies?page=2')
            .then((response) => {
                vm.movies = response.data.movieList;
            })
            .catch((ex) => {
                console.log("get movie list error" + ex);
            })
    }
}
</script>

<style>
    #movie-list-table {
        margin: auto;
    }
</style>