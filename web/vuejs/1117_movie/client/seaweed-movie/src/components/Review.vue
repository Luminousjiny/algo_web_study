<template>
    <div id="review">
        <table id="review-table">
            <tr>
                <th>작성자</th>
                <th>리뷰 내용</th>
                <th>작성일</th>
            </tr>
            <tr v-for="review in reviews" :key="review.rno">
                <td>{{review.rwriter}}</td>
                <td>{{review.rcontent}}</td>
                <td>{{review.rdate}}</td>
                <td><button @click="updateClicked(review.rno, review.rcontent)">수정</button></td>
                <td><button @click="deleteReview(review.rno)">삭제</button></td>
            </tr>
        </table>

        <table id="review-add-table">
            <tr v-if="update">
                <td><input v-model="newReview.rcontent" type="text"></td>
                <td><button @click="updateReview">리뷰 수정</button></td>
            </tr>
            <tr v-else>
                <td><input v-model="newReview.rcontent" type="text" placeholder="리뷰 내용을 작성해주세요"></td>
                <td><button @click="addReview">리뷰 등록</button></td>
            </tr>
        </table>
    </div>
</template>

<script>
import axios from 'axios';
export default {
    props: {
        'propsmno': Number
    },
    data(){
        return {
            update: false,
            reviews : [],
            newReview : {
                mno: this.propsmno,
                rwriter : 'ssafy',
                rcontent : ''
            }
        };
    },
    created(){
        this.getReview();
    },
    methods: {
        getReview: function(){
            axios.get('http://localhost:8097/movieboard/api/reviews/' + this.propsmno)
            .then((response) => {
                this.reviews = response.data;
            })
            .catch((ex) => {
                console.log("get review error : " + ex);
            })
        },
        addReview: function(){
            axios.post('http://localhost:8097/movieboard/api/reviews/' + this.propsmno, this.newReview)
                .then((response) => {
                    var result = response.data;
                    if(result == "success"){
                        alert("리뷰 등록 성공");
                    } else {
                        alert("리뷰 등록 실패");
                    }
                    this.getReview();
                    this.newReview = {
                        mno: 0,
                        rwriter : 'ssafy',
                        rcontent : ''
                    };
                })
        },
        deleteReview: function(rno){
            axios.delete('http://localhost:8097/movieboard/api/reviews/' + rno)
                .then((response) => {
                    var result = response.data;
                    if(result == "success"){
                        alert("댓글 삭제 성공");
                    } else {
                        alert("댓글 삭제 실패");
                    }
                    this.getReview();
                })
                .catch((error) => {
                    console.log(error);
                    alert("댓글 삭제 중 에러 발생");
                })
        },
        updateClicked: function(rno, rcontent){
            this.update = true;
            this.newReview.rno = rno;
            this.newReview.rcontent = rcontent;
        },
        updateReview: function(){
            axios.put('http://localhost:8097/movieboard/api/reviews/' + this.newReview.rno, this.newReview)
                .then((response) => {
                    var result = response.data;
                    if(result == "success"){
                        alert("댓글 수정 성공");
                    } else {
                        alert("댓글 수정 실패");
                    }
                    this.getReview();
                })
                .catch((error) => {
                    console.log(error);
                    alert("리뷰 수정 중 에러 발생");
                })
        }
    }
}
</script>

<style>
    #review-table, #review-add-table {
        margin: auto;
    }
</style>