<template>
  <h2>Users</h2>
  <ul v-if="users.length">
    <li v-for="user in users" :key="user.id">
      {{ user.username || user.id }}
    </li>
  </ul>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getUsers } from '@/api/api.js';

const users = ref([]);

onMounted(async () => {
  users.value = await getUsers();
});
</script>