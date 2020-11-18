<template>
    <div id="movie-update">
        <table id="movie-update-table">
            <tr>
                <th>영화 번호</th>
                <td>{{movie.mno}}</td>
            </tr>
            <tr>
                <th>제목</th>
                <td><input type="text" v-model="movie.mtitle"></td>
            </tr>
            <tr>
                <th>개봉일</th>
                <td>{{movie.mdate}}</td>
            </tr>
            <tr>
                <th>감독</th>
                <td><input type="text" v-model="movie.mdirector"></td>
            </tr>
            <tr>
                <th>줄거리</th>
                <td><textarea name="mcontent" id="mcontent" cols="30" rows="10" v-model="movie.mcontent"></textarea></td>
            </tr>
        </table>
        <button @click="updateMovie">수정</button>
    </div>
</template>

<script>
import axios from 'axios';

export default {
    data: function(){
        return {
            movie: {}
        };
    },
    created: function(){
        this.movie = this.$route.params.movie;
    },
    methods: {
        updateMovie: function(){
            axios.put('http://localhost:8097/movieboard/api/movies/' + this.movie.mno, this.movie)
                .then((response) => {
                    var result = response.data;
                    if(result == "success"){
                        alert("영화 수정 성공");
                    } else {
                        alert("영화 수정 실패");
                    }
                    this.$router.push({
                        path: "/movies/list"
                    })
                })
                .catch((error) => {
                    console.log(error);
                    alert("영화 업데이트 과정 중 에러 발생");
                })
        }
    }
}
</script>

<style>
    #movie-update-table {
        margin: auto;
    }
</style>