<template lang="">
  <div align="center">
    <router-link :to="{ name: 'SignUpPage' }">
      <v-btn color="primary">회원 가입</v-btn>
    </router-link>
    <LoginComponent @click="login" />
    </div>
  </div>
</template>

<script>
import LoginComponent from "@/components/account/LoginComponent.vue";
import { mapActions } from "vuex";

const accountModule = "accountModule";

export default {
  components: {
    LoginComponent,
  },
  methods: {
    ...mapActions(accountModule, ["requestLoginToSpring"]),
    async login(payload) {
      await this.requestLoginToSpring(payload);
      await this.$router.push({
        name: 'GameLevelPage'
      })
    },
  },
};
</script>

<style lang=""></style>
