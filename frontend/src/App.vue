<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/trees">Family Trees</router-link>
  </nav>
  <router-view />
</template>

<style>
nav {
  margin: 1em 0;
}
nav a {
  margin-right: 1em;
}
</style>