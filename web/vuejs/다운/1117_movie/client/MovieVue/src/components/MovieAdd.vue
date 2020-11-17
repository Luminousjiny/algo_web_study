<template>
  <div>
      <table>
        <tr>
          <th>영화 제목</th>
          <td><input type="text" name="mtitle" v-model="movie.mtitle" required /></td>
        </tr>
        <tr>
          <th>영화 개봉일</th>
          <td><input type="date" name="mdate" v-model="movie.mdate" /></td>
        </tr>
        <tr>
          <th>영화 감독</th>
          <td><input type="text" name="mdirector" v-model="movie.mdirector" /></td>
        </tr>
        <tr>
          <th>영화 줄거리</th>
          <td><textarea rows="4" cols="50" name="mcontent" v-model="movie.mcontent" /></td>
        </tr>
      </table>
      <button><a href="#" @click="send">등록</a></button>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    data() {
        return{
            movies : [],
          movie  : {
            mtitle: '',
            mdate: '',
            mdirector: '',
            mcontent: '',
          },
            }
        },
        methods: {
          send(){
            axios.post('http://localhost:8097/movieboard/api/movies', this.movie )
            .then((response)=>{
                alert(response.data);
                this.$router.push('/MovieList');
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
        width: 600px;
      }
</style>
