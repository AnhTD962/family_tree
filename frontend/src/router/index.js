import { createRouter, createWebHistory } from 'vue-router';
import Home from '../views/Home.vue';
import FamilyTreeList from '../views/FamilyTreeList.vue';
import FamilyMemberList from '../views/FamilyMemberList.vue';
import FamilyMemberDetail from '../views/FamilyMemberDetail.vue';
import UserList from '../views/UserList.vue';
import MediaList from '../views/MediaList.vue';
import NoteList from '../views/NoteList.vue';
import RelationshipList from '../views/RelationshipList.vue';
import FamilyTreeDetail from '../views/FamilyMemberDetail.vue';
import LoginView from '../views/auth/Login.vue'

const routes = [
  { path: '/', component: Home },
  { path: '/trees', component: FamilyTreeList },
  { path: '/trees/:id', component: FamilyTreeDetail, props: true },
  { path: '/members/:treeId', component: FamilyMemberList, props: true },
  { path: '/members/detail/:id', component: FamilyMemberDetail, props: true },
  { path: '/users', component: UserList },
  { path: '/media', component: MediaList },
  { path: '/notes', component: NoteList },
  { path: '/relationships', component: RelationshipList },
  { path: '/login', component: LoginView, name: 'login' }
];

const router = createRouter({
  history: createWebHistory(),
  routes
});

export default router;