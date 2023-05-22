<template lang="">
    <div>
      <GameLevelComponent @click="onClick" />
    </div>
  </template>
  
  <script>
  import GameLevelComponent from "@/components/game/GameLevelComponent.vue";
  import { mapActions } from "vuex";
  
  const gameModule = "gameModule";
  
  export default {
    components: {
      GameLevelComponent,
    },
    methods: {
      ...mapActions(gameModule, ["sendGameLevelToSpring"]),
      async onClick(payload) {
        await this.sendGameLevelToSpring(payload);
        await this.$router.push({
          name: "GamePlayPage",
          params: { numberCount: payload.numberCount },
        });
      },
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
  