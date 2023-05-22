<template lang="">
  <div>
    <form @submit.prevent="createAccount">
      <label> 이메일: <input type="text" v-model="email" required /> </label
      ><br />
      <label> 닉네임: <input type="text" v-model="nickname" required /> </label
      ><br />
      <label>
        비밀번호: <input type="password" v-model="password" required /> </label
      ><br />
      <div align="center">
        <v-btn color="primary" type="submit">가입</v-btn>
        <router-link :to="{ name: 'home' }"> 취소 </router-link>
      </div>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      email: "",
      nickname: "",
      password: "",
    };
  },
  methods: {
    createAccount() {
      const { email, nickname, password } = this;
      this.$emit("submit", { email, nickname, password });
    },
  },
};
</script>
<style lang=""></style>
