<template>
  <div id="app">
    <div id="nav">
      <h3>스터디 - Movie</h3>
      <router-link to="/">Home</router-link> |
      <router-link to="/movies/list">영화 목록</router-link> |
      <router-link to="/movies/add">영화 등록</router-link>
    </div>
    <router-view />
  </div>
</template>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
}

#nav {
  padding: 30px;
}

#nav a {
  font-weight: bold;
  color: #2c3e50;
}

#nav a.router-link-exact-active {
  color: #42b983;
}
</style>
