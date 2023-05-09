import Vue from 'vue'
import Vuex from 'vuex'

import mutations from "@/store/game/mutations"
import actions from "@/store/game/actions"
import state from "@/store/game/state"

Vue.use(Vuex)

const GameModule = {
    namespaced: true,
    state,
    actions,
    mutations,
}

export default GameModule