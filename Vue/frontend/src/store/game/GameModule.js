import Vue from 'vue'
import Vuex from 'vuex'

import actions from "@/store/game/actions"

Vue.use(Vuex)

const GameModule = {
    namespaced: true,
    actions,
}

export default GameModule