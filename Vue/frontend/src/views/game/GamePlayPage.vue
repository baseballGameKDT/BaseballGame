<template>
    <div>
        <GamePlayComponent :numberCount="numberCount" :resultList="resultList" @submit="getResult"/>
        <v-layout justify-center>
      <v-dialog v-model="endGame" width="400px" height="400px">
        <v-card>
          <v-card-title class="headline">
            {{ finalResult }}
          </v-card-title>
          <v-card-text>
            정답은: {{ answer }}
          </v-card-text>
          <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn color="teal darken-1" @click="playAgain"> 다시하기 </v-btn>
          </v-card-actions>
        </v-card>
      </v-dialog>
    </v-layout> 
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
            round: {},
            endGame: false,
            finalResult: '',
            answer: ''
        }
    },
    components: {
        GamePlayComponent,
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
            if (this.round.result[1] == null) {
            await this.resultList.push(this.round)
            } else {
            this.finalResult = this.round.result[1];
            this.answer = this.round.result[2];
            this.endGame = true;
            }
        },
        playAgain() {
            this.$router.push({
                name: 'GameLevelPage'
            })
            this.endGame = false
        }
    }
}
</script>

<style>
  
</style>