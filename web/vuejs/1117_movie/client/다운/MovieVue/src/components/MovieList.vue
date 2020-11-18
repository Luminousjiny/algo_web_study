<template>
  <div>
      <div id="movieList">
      <table border="1px">
        <thead>
          <th>번호</th>
          <th>영화 제목</th>
          <th>영화 개봉일</th>
          <th>영화 감독</th>
        </thead>
        <tr v-for="m in movies.movieList" v-bind:key="m.mno">
          <td> <router-link :to="{name: 'MovieRead', params: {mno: m.mno}}">{{m.mno}}</router-link></td>
          <td>{{m.mtitle}}</td>
          <td>{{m.mdate}}</td>
          <td>{{m.mdirector}}</td>
        </tr>
      </table>
    </div>

  </div>
</template>

<script>
import axios from 'axios';
export default {
    created(){
        axios.get('http://localhost:8097/movieboard/api/movies', {
          params: {
            page: 2
          }
        })
        .then((response)=>{
            this.movies = response.data;
        })
        .catch((ex)=>{
            console.log(ex);
        })
    },
    data() {
        return {
            movies : [],
        }
    },
}
</script>