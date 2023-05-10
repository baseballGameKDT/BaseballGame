import Vue from "vue";
import VueRouter from "vue-router";

import GameLevelPage from "@/views/game/GameLevelPage.vue"
import GamePlayPage from "@/views/game/GamePlayPage.vue"

Vue.use(VueRouter);

const gameRoutes = [
    {
        path: "/game-level-page",
        name: "GameLevelPage",
        component: GameLevelPage,
      },
      {
        path: "/game-play-page",
        name: "GamePlayPage",
        components: {
          default: GamePlayPage,
        },
        props: {
          default: true,
        }
      },
]

export default gameRoutes