<template>
  <h2>Notes</h2>
  <ul v-if="notes.length">
    <li v-for="note in notes" :key="note.id">
      <div>{{ note.content }}</div>
      <small>By {{ note.authorId }} (Tree: {{ note.treeId }}, Member: {{ note.memberId }})</small>
    </li>
  </ul>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getAllNotes } from '@/api/api.js';

const notes = ref([]);

onMounted(async () => {
  notes.value = await getAllNotes();
});
</script>