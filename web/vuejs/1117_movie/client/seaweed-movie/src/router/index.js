import Vue from "vue";
import VueRouter from "vue-router";
import Home from "../views/Home.vue";
import MovieAdd from "@/views/MovieAdd.vue";
import MovieDetail from "@/views/MovieDetail.vue";
import MovieList from "@/views/MovieList.vue";
import MovieUpdate from "@/views/MovieUpdate.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "Home",
    component: Home
  },
  {
    path: "/movies/list",
    name: "MovieList",
    component: MovieList
  },
  {
    path: "/movies/add",
    name: "MovieAdd",
    component: MovieAdd
  },
  {
    path: "/movies/:mno",
    name: "MovieDetail",
    component: MovieDetail
  },
  {
    path: "/movies/update",
    name: "MovieUpdate",
    component: MovieUpdate
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
