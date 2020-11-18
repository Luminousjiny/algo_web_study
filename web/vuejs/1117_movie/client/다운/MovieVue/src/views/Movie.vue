<template>
    <div>
         <h2>영화 사이트</h2>
         <movie-nav></movie-nav>
         <router-view />
    </div>
</template>

<script>
import MovieNav from "@/components/MovieNav.vue";
export default {
    components : {
        MovieNav
    }
}
</script>

<style>
table{
    margin-top: 50px;
}
</style>