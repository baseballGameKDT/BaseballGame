<template lang="">
  <div>
    <v-btn v-if="!isLoggedIn" @click="readyToLogin">로그인</v-btn>
    <div v-if="isReadyToLogin">
      <label> 이메일: <input type="text" v-model="email" required /> </label
      ><br />
      <label>
        비밀번호: <input type="password" v-model="password" required /> </label
      ><br />
      <v-btn @click="login">로그인</v-btn>
    </div>
  </div>
</template>
<script>
export default {
  data() {
    return {
      email: "",
      password: "",
      isReadyToLogin: false,
      isLoggedIn: false,
    };
  },
  methods: {
    login() {
      const { email, password } = this;
      this.$emit("click", { email, password });
      this.isReadyToLogin = false;
    },
    readyToLogin() {
      this.isReadyToLogin = true;
    },
  },
  mounted() {
    if (localStorage.getItem("loginUserId") == null) {
      this.isLoggedIn = false;
    } else {
      this.isLoggedIn = true;
    }
  },
};
</script>
<style lang=""></style>
