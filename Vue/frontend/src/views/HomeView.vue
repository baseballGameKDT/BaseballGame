<template lang="">
  <div>
    <router-link :to="{ name: 'SignUpPage' }">
      <v-btn v-if="!isLoggedIn" color="primary">회원 가입</v-btn>
    </router-link>
    <LoginComponent @click="login" /><br />
    <div v-if="isLoggedIn">
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
      this.nickname = localStorage.getItem("loginUserNickName");
    }
  },
};
</script>

<style scoped>
div {
  margin: 30px 30px;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
}
</style>
