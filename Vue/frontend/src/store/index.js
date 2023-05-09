import Vue from "vue";
import Vuex from "vuex";

import gameModule from "./game/GameModule";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    gameModule: gameModule,
  },
});

export default store;
