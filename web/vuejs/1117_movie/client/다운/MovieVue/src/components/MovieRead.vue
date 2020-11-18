<template>
  <div>
      <table border="1">
        <tr>
          <th>영화 번호</th>
          <td>{{ movie.mno }}</td>
        </tr>
        <tr>
          <th>영화 제목</th>
          <td>{{ movie.mtitle }}</td>
        </tr>
        <tr>
          <th>영화 개봉일</th>
          <td>{{ movie.mdate }}</td>
        </tr>
        <tr>
          <th>영화 감독</th>
          <td>{{ movie.mdirector }}</td>
        </tr>
        <tr>
          <th>영화 줄거리</th>
          <td>{{ movie.mcontent }}</td>
        </tr>
      </table>
      <button @click="update">글수정</button>
      <button @click="deleteBoard">글삭제</button>
      
      <h3>Review</h3>
      <table>
        <thead>
            <th>번호</th>
            <th>작성자</th>
            <th>작성일</th>
            <th>리뷰 내용</th>
        </thead>
        <tbody>
          <tr v-for="c in comments" v-bind:key="c.rno">
              <td>{{ c.rno }}</td>
              <td><input type="text" name="rwriter" v-model="c.rwriter"></td>
              <td><input type="date" name="rdate" v-model="c.rdate"></td>
              <td><input type="text" name="rcontent" v-model="c.rcontent"></td>
              <td><button @click="updateReview(c)">수정</button></td>
              <td><button @click="deleteReview(c.rno)">삭제</button></td>
          </tr>
        </tbody>
      </table>

      <!--리뷰 작성-->
      <table border="1" id="addReview">
      <tr>
        <th>리뷰 작성자</th>
        <td><input type="text" name="rwriter" v-model="comment.rwriter" /></td>
      </tr>
      <tr>
        <th>리뷰 내용</th>
        <textarea rows="4" cols="50" name="rcontent" v-model="comment.rcontent" />
      </tr>
      </table>
      <button @click="addReview">리뷰 작성</button>
  </div>
</template>

<script>
import axios from 'axios';
export default {
    created(){
        //상세 보기
        axios.get('http://localhost:8097/movieboard/api/movies/' + this.$route.params.mno)
        .then((response)=>{
            this.movie = response.data;
        })
        .catch((ex)=>{
            console.log(ex);
        })
        //댓글 목록
        axios.get('http://localhost:8097/movieboard/api/reviews/' + this.$route.params.mno)
        .then((response)=>{
          this.comments = response.data;
        })
        .catch((ex)=>{
            console.log(ex);
        })
    },
    data() {
        return {
            movie : [],
            comments: [],
            comment:{ //댓글 입력 데이터
              rcontent:'',
              rdate:'',
              rwriter:'ssafy',
            },
            c:{ //댓글 수정 데이터
              rcontent:'',
              rdate:'',
              rwriter:'ssafy',
            }
        }
    },
    methods: {
        update(){
            this.$router.push({name: 'MovieUpdate', params: {movie: this.movie}})
        },
        deleteBoard(){
          axios.delete('http://localhost:8097/movieboard/api/movies/' + this.movie.mno)
          .then(()=>{
              this.$router.push('/MovieList');
          })
          .catch((ex)=>{
              console.log(ex);
          })
        },
        addReview(){
          axios.post('http://localhost:8097/movieboard/api/reviews/' + this.movie.mno, this.comment)
          .then(()=>{
            alert();
              this.$router.push('/MovieList');
          })
          .catch((ex)=>{
              console.log(ex);
          })
        },
        deleteReview(rno){
          axios.delete('http://localhost:8097/movieboard/api/reviews/' + rno)
          .then(()=>{
              this.$router.push('/MovieList');
          })
          .catch((ex)=>{
              console.log(ex);
          })
        },
        updateReview(c){
          axios.put('http://localhost:8097/movieboard/api/reviews/' + c.rno, c)
          .then((resp)=>{
              alert(resp.data);
              this.$router.push('/MovieList');
          })
          .catch((ex)=>{
              console.log(ex);
          })
        }
    },
}
</script>


<style>
      table {
        margin: auto;
        width: 800px;
      }

      th{
          width: 50px;
      }

       td{
           width:800px;
       }

       h3{
         margin-top:100px;
         margin-bottom:20px;
       }

       #addReview{
         margin-top:50px;
       }
</style>
