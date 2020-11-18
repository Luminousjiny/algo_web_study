import Vue from "vue";
import VueRouter from "vue-router";
import Movie from "../views/Movie.vue";
import MovieList from "@/components/MovieList.vue";
import MovieAdd from "@/components/MovieAdd.vue";
import MovieRead from "@/components/MovieRead.vue";
import MovieUpdate from "@/components/MovieUpdate.vue";

Vue.use(VueRouter);

const routes = [
  {
    path: "/",
    name: "MovieList",
    component: Movie
  },
  {
    path: "/Movie",
    name: "Movie",
    component: Movie,
    redirect: "/MovieList",
    children: [
      {
        path: "/MovieList",
        name: "MovieList",
        component: MovieList
      },
      {
        path: "/MovieAdd",
        name: "MovieAdd",
        component: MovieAdd
      },
      {
        path: "/MovieRead/:mno",
        name: "MovieRead",
        component: MovieRead
      },
      {
        path: "/MovieUpdate",
        name: "MovieUpdate",
        component: MovieUpdate
      },
    ]
  },
  
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

export default router;
