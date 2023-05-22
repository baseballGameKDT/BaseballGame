<template lang="">
  <div align="center">
    <router-link :to="{ name: 'SignUpPage' }">
      <v-btn v-if="!isLoggedIn" color="primary">회원 가입</v-btn>
    </router-link>
    <LoginComponent @click="login" /><br />
    <router-link :to="{ name: 'GameLevelPage' }">
      <v-btn v-if="isLoggedIn" color="primary">게임 플레이</v-btn>
    </router-link>
  </div>
</template>

<script>
import LoginComponent from "@/components/account/LoginComponent.vue";
import { mapActions } from "vuex";

const accountModule = "accountModule";

export default {
  data() {
    return {
      isLoggedIn: false,
    };
  },
  components: {
    LoginComponent,
  },
  methods: {
    ...mapActions(accountModule, ["requestLoginToSpring"]),
    async login(payload) {
      await this.requestLoginToSpring(payload);
      location.reload();
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
