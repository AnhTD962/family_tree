<template>
  <div v-if="member">
    <h2>{{ member.firstName }} {{ member.lastName }}</h2>
    <img v-if="member.photoUrl" :src="member.photoUrl" alt="Photo" style="max-width:150px">
    <p>Gender: {{ member.gender }}</p>
    <p>Date of Birth: {{ member.dateOfBirth }}</p>
    <p>Date of Death: {{ member.dateOfDeath }}</p>
    <p>Notes: {{ member.notes }}</p>
  </div>
  <div v-else>Loading...</div>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getFamilyMember } from '@/api/api.js';
import { useRoute } from 'vue-router';

const route = useRoute();
const member = ref(null);

onMounted(async () => {
  member.value = await getFamilyMember(route.params.id);
});
</script>