<template>
  <div>
       <table>
        <tr>
          <th>영화 제목</th>
          <td><input type="text" name="mtitle" v-model="movie.mtitle" required/></td>
        </tr>
        <tr>
          <th>영화 개봉일</th>
          <td><input type="date" name="mdate" v-model="movie.mdate" required/></td>
        </tr>
        <tr>
          <th>영화 감독</th>
          <td><input type="text" name="mdirector" v-model="movie.mdirector" required/></td>
        </tr>
        <tr>
          <th>영화 줄거리</th>
          <td><textarea rows="10" cols="50" name="mcontent" v-model="movie.mcontent" required/></td>
        </tr>
      </table>
      <button><a href="#" @click="update">수정하기</a></button>
  </div>
</template>

<script>
import axios from 'axios';
export default {
  data() {
        return{
            movies : [],
          movie  : {
            mno: this.$route.params.movie.mno,
            mtitle: this.$route.params.movie.mtitle,
            mdate: this.$route.params.movie.mdate,
            mdirector: this.$route.params.movie.mdirector,
            mcontent: this.$route.params.movie.mcontent,
          },
            }
        },
        methods: {
          update(){
            axios.put('http://localhost:8097/movieboard/api/movies/'+this.$route.params.movie.mno, this.movie )
            .then(()=>{
                this.$router.push('/MovieList'); //영화목록으로 이동
            })
            .catch((ex)=>{
                alert('error'+ex);
            })
          }
        },
}
</script>


<style>
      table {
        margin: auto;
        width: 1000px;
      }

      th{
          width: 300px;
      }
</style>
