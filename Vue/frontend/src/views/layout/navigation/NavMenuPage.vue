<template lang="">
  <nav>
    <v-app-bar color="green">
      </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn v-if="isLogin" text @click="logout">
        <span>로그아웃</span>
        <v-icon>mdi-exit-to-app</v-icon>
      </v-btn>
    </v-app-bar>
  </nav>
</template>
<script>
export default {
  data() {
    return {
      isLogin: false,
      accountId: 0
    };
  },
  methods: {
    logout() {
        this.isLogin = false
        localStorage.clear()
        this.$router.push({
            name: "home"
        }).catch(() => {
            location.reload()
        })
    }
  },
  mounted () {
    this.accountId = localStorage.getItem("loginUserId")
    if (this.accountId > 0) {
        this.isLogin = true
    }
  }
};
</script>
<style lang=""></style>
