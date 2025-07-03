<template>
  <nav>
    <router-link to="/">Home</router-link> |
    <router-link to="/trees">Family Trees</router-link> |
    <router-link to="/login" v-if="!auth.token">Login</router-link>
    <span v-else>
      | <a href="#" @click.prevent="logout">Logout</a>
    </span>
  </nav>
  <router-view />
</template>

<script setup>
import { useAuthStore } from '@/store/auth.js'
const auth = useAuthStore()

function logout() {
  auth.logout()
}
</script>

<style>
nav {
  margin: 1em 0;
}
nav a {
  margin-right: 1em;
}
</style>
