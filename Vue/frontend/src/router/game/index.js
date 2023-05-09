import Vue from "vue";
import VueRouter from "vue-router";

import GameLevelPage from "@/views/game/GameLevelPage.vue"

Vue.use(VueRouter);

const gameRoutes = [
    {
        path: "/game-level-page",
        name: "GameLevelPage",
        component: GameLevelPage,
      },
]

export default gameRoutes