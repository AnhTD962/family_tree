<template>
  <h2>Family Members</h2>
  <ul v-if="members.length">
    <li v-for="member in members" :key="member.id">
      <router-link :to="`/members/detail/${member.id}`">
        {{ member.firstName }} {{ member.lastName }}
      </router-link>
    </li>
  </ul>
  <form @submit.prevent="submit">
    <h3>Add Family Member</h3>
    <input v-model="form.firstName" placeholder="First Name" required>
    <input v-model="form.lastName" placeholder="Last Name" required>
    <input v-model="form.gender" placeholder="Gender">
    <input v-model="form.dateOfBirth" placeholder="Date of Birth">
    <input v-model="form.photoUrl" placeholder="Photo URL">
    <button>Add</button>
  </form>
</template>

<script setup>
import { ref, onMounted } from 'vue';
import { getFamilyMembersByTree, addFamilyMember } from '@/api/api.js';
import { useRoute } from 'vue-router';

const route = useRoute();
const members = ref([]);
const form = ref({
  treeId: route.params.treeId,
  firstName: '',
  lastName: '',
  gender: '',
  dateOfBirth: '',
  photoUrl: ''
});

async function load() {
  members.value = await getFamilyMembersByTree(route.params.treeId);
}
onMounted(load);

async function submit() {
  await addFamilyMember(form.value);
  form.value = {
    treeId: route.params.treeId,
    firstName: '',
    lastName: '',
    gender: '',
    dateOfBirth: '',
    photoUrl: ''
  };
  await load();
}
</script>