<template>
  <h2>Media</h2>
  <ul v-if="media.length">
    <li v-for="m in media" :key="m.id">
      <a :href="m.url" target="_blank">{{ m.type }}</a> ({{ m.treeId }} - {{ m.memberId }})
    </li>
  </ul>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getAllMedia } from '@/api/api.js';

const media = ref([]);

onMounted(async () => {
  media.value = await getAllMedia();
});
</script>