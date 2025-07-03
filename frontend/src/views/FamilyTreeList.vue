<template>
  <h2>Family Trees</h2>
  <ul v-if="trees.length">
    <li v-for="tree in trees" :key="tree.id">
      <router-link :to="`/trees/${tree.id}`">{{ tree.name }}</router-link>
    </li>
  </ul>
  <form @submit.prevent="submit">
    <h3>Add Family Tree</h3>
    <input v-model="form.name" placeholder="Name" required>
    <input v-model="form.description" placeholder="Description">
    <input v-model="form.ownerId" placeholder="Owner ID" required>
    <button>Add</button>
  </form>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getFamilyTrees, createFamilyTree } from '@/api/api.js';

const trees = ref([]);
const form = ref({ name: '', description: '', ownerId: '' });

async function load() {
  trees.value = await getFamilyTrees();
}
onMounted(load);

async function submit() {
  await createFamilyTree(form.value);
  form.value = { name: '', description: '', ownerId: '' };
  await load();
}
</script>