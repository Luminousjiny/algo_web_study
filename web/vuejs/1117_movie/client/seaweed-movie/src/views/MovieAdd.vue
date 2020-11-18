<template>
    <div id="movie-add">
        <table id="movie-add-table">
            <tr>
                <th>영화 제목</th>
                <td><input type="text" v-model="movie.mtitle"></td>
            </tr>
            <tr>
                <th>영화 감독</th>
                <td><input type="text" v-model="movie.mdirector"></td>
            </tr>
            <tr>
                <th>영화 내용</th>
                <td><input type="text" v-model="movie.mcontent"></td>
            </tr>
        </table>
        <button @click="addMovie">영화 등록</button>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    data: function(){
        return {
            movie: {
                mtitle: '',
                mcontent: '',
                mdirector: ''
            }
        };
    },
    methods: {
        addMovie: function(){
            axios.post('http://localhost:8097/movieboard/api/movies', this.movie)
                .then((response) => {
                    var result = response.data;
                    if(result == "success"){
                        alert("등록 성공");
                    } else {
                        alert("등록 실패");
                    }
                    this.$router.push({
                        path: '/movies/list'
                    })
                })
                .catch((ex) => {
                    console.log("movie add error : " + ex);
                })
        }
    }
}
</script>

<style>
    #movie-add-table {
        margin: auto;
    }
</style>