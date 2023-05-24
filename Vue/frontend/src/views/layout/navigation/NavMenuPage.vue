<template lang="">
  <nav>
    <v-app-bar color="green darken-3">
      </v-toolbar-title >
      <span style="color: white">
        <v-icon style="color: white">mdi-baseball</v-icon>
        <b>
          재밌는 숫자야구 게임
        </b>
      </span>
      <v-spacer></v-spacer>
      <span style="color: white" >
        <b>
          {{ nickname }} 님 어서오세요
        </b>
      </span>
    </v-toolbar-title>
      <v-spacer></v-spacer>
      <v-btn v-if="isLogin" @click="logout">
        <span >로그아웃</span>
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
      accountId: 0,
      nickname: localStorage.getItem("loginUserNickName")
    };
  },
  methods: {
    logout() {
        this.isLogin = false
        localStorage.clear()
        this.$router.push({
            name: "home"
        })
        location.reload()
        .catch(() => {
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
