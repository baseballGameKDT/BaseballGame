import Vue from "vue";
import Vuex from "vuex";

import gameModule from "./game/GameModule";
import AccountModule from "./account/AccountModule";

Vue.use(Vuex);

const store = new Vuex.Store({
  modules: {
    gameModule: gameModule,
    accountModule: AccountModule,
  },
});

export default store;
