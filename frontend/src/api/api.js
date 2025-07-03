import axios from 'axios';

const api = axios.create({ baseURL: '/api' });

export function getFamilyTrees() {
  return api.get('/family-trees').then(res => res.data);
}
export function getFamilyTree(id) {
  return api.get(`/family-trees/${id}`).then(res => res.data);
}
export function createFamilyTree(tree) {
  return api.post('/family-trees', tree).then(res => res.data);
}
export function getFamilyMembersByTree(treeId) {
  return api.get(`/family-members/tree/${treeId}`).then(res => res.data);
}
export function getFamilyMember(id) {
  return api.get(`/family-members/${id}`).then(res => res.data);
}
export function addFamilyMember(member) {
  return api.post('/family-members', member).then(res => res.data);
}
export function getUsers() {
  return api.get('/users').then(res => res.data);
}
export function getAllMedia() {
  return api.get('/media').then(res => res.data);
}
export function getAllNotes() {
  return api.get('/notes').then(res => res.data);
}
export function getAllRelationships() {
  return api.get('/relationships').then(res => res.data);
}