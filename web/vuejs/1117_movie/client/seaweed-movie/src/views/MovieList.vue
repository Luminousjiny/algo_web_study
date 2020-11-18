<template>
    <div id="movie-list">
        <table id="movie-list-table">
            <tr>
                <th>제목</th>
                <th>감독</th>
                <th>개봉일</th>
            </tr>
            <tr v-for="movie in items" :key="movie.mno">
                <td><router-link :to="'/movies/' + movie.mno">{{movie.mtitle}}</router-link></td>
                <td>{{ movie.mdirector }}</td>
                <td>{{ movie.mdate }}</td>
            </tr>
        </table>
    </div>
</template>

<script>
import {mapGetters} from 'vuex';

export default {
    computed: {
        ...mapGetters(['items'])
    },
    created(){
        this.$store.dispatch("getMovieList");
    }
}
</script>

<style>
    #movie-list-table {
        margin: auto;
    }
</style>