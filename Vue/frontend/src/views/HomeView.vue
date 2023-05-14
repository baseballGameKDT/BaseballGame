<template lang="">
  <div align="center">
    <router-link :to="{ name: 'SignUpPage'}">
      <v-btn color="primary">회원 가입</v-btn>
    </router-link> <br>
    <router-link :to="{ name: 'GameLevelPage'}">
      <v-btn color="primary">게임 플레이</v-btn>
    </router-link>
  </div>
</template>

<script>

export default {

}

</script>

<style lang="">
  
</style>