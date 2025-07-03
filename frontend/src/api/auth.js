import api from "./axios";

export function register(user) {
  return api.post(`/auth/register`, user);
}

export function login(credentials) {
  return api.post(`/auth/login`, credentials);
}
