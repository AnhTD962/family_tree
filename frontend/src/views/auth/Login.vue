<template>
  <div class="login-container">
    <h2>Login</h2>
    <form @submit.prevent="submit">
      <div>
        <label for="username">Username</label>
        <input v-model="form.username" id="username" required autocomplete="username" />
      </div>
      <div>
        <label for="password">Password</label>
        <input v-model="form.password" id="password" type="password" required autocomplete="current-password" />
      </div>
      <button :disabled="loading" type="submit">Login</button>
      <div v-if="error" class="error">{{ error }}</div>
    </form>
  </div>
</template>

<script setup>
import { ref } from 'vue'
import { useAuthStore } from '../../store/auth'
import { useRouter } from 'vue-router'
import { login } from '../../api/auth' // đường dẫn tới file bạn post phía trên

const form = ref({ username: '', password: '' });
const loading = ref(false);
const error = ref('');
const router = useRouter();
const authStore = useAuthStore();

async function submit() {
  error.value = '';
  loading.value = true;
  try {
    const response = await login(form.value);
    const token = response.data.token;

    // Lưu token và cập nhật trạng thái đăng nhập
    authStore.setToken(token); // bạn cần có hàm này trong store
    authStore.setUser(response.data.user); // nếu API trả về thông tin user

    router.push('/'); // chuyển hướng sau khi login
  } catch (err) {
    error.value = err.response?.data?.message || 'Login failed';
  } finally {
    loading.value = false;
  }
}
</script>

<style scoped>
.login-container {
  max-width: 400px;
  margin: 2em auto;
  padding: 2em;
  border: 1px solid #ccc;
  border-radius: 8px;
}
.error {
  color: red;
  margin-top: 1em;
}
</style>