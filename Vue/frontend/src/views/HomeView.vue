<template lang="">
  <div align="center">
    <router-link :to="{ name: 'SignUpPage' }">
      <v-btn color="primary">회원 가입</v-btn>
    </router-link>
    <LoginComponent @click="login" /><br />
    <div v-if="isLoggedIn">
      {{ nickName }} 님 어서오세요!
      <router-link :to="{ name: 'GameLevelPage' }">
        <v-btn color="primary">게임 플레이</v-btn>
      </router-link>
    </div>
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
      nickName: "",
    };
  },
  components: {
    LoginComponent,
  },
  methods: {
    ...mapActions(accountModule, ["requestLoginToSpring"]),
    async login(payload) {
      await this.requestLoginToSpring(payload);
    },
  },
  mounted() {
    if (localStorage.getItem("loginUserId") == null) {
      this.isLoggedIn = false;
    } else {
      this.isLoggedIn = true;
      this.nickName = localStorage.getItem("loginUserNickName");
    }
  },
};
</script>

<style lang=""></style>
