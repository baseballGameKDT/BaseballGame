<template>
    <div>
        <GamePlayComponent :numberCount="numberCount" :resultList="resultList" @submit="getResult"/>
    </div>
</template>

<script>
import GamePlayComponent from "@/components/game/GamePlayComponent.vue"
import { mapActions } from "vuex";

const gameModule = 'gameModule'

export default {
    data () {
        return {
            resultList: [],
            round: {}
        }
    },
    components: {
        GamePlayComponent
    },
    props: {
        numberCount: {
            type: String,
            required: true
        }
    },
    methods: {
        ...mapActions( gameModule, ['requestGameResultToSpring']),

        async getResult(payload) {
            this.round = await this.requestGameResultToSpring(payload)
            await this.resultList.push(this.round)
        }
    }
}
</script>

<style>
  
</style>