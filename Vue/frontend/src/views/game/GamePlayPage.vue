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

        getResult(payload) {
            this.resultList.put(this.requestGameResultToSpring(payload))
        }
    }
}
</script>

<style>
    
</style>