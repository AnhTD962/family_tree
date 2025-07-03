<template>
  <h2>Relationships</h2>
  <ul v-if="relationships.length">
    <li v-for="rel in relationships" :key="rel.id">
      {{ rel.memberId1 }} - {{ rel.type }} - {{ rel.memberId2 }} (Tree: {{ rel.treeId }})
    </li>
  </ul>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getAllRelationships } from '@/api/api.js';

const relationships = ref([]);

onMounted(async () => {
  relationships.value = await getAllRelationships();
});
</script>