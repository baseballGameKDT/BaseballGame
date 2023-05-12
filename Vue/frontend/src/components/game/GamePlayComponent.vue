<template>
    <div>
        <div class="right" align="center">
            <button v-if="!isClicked1" class="button" @click="selectNumber1($event)" value="1">1</button>
            <button v-if="isClicked1" class="button disabled">1</button>
            <button v-if="!isClicked2" class="button" @click="selectNumber2($event)" value="2">2</button>
            <button v-if="isClicked2" class="button disabled">2</button>
            <button v-if="!isClicked3" class="button" @click="selectNumber3($event)" value="3">3</button>
            <button v-if="isClicked3" class="button disabled">3</button> <br>
            <button v-if="!isClicked4" class="button" @click="selectNumber4($event)" value="4">4</button>
            <button v-if="isClicked4" class="button disabled">4</button>
            <button v-if="!isClicked5" class="button" @click="selectNumber5($event)" value="5">5</button>
            <button v-if="isClicked5" class="button disabled">5</button>
            <button v-if="!isClicked6" class="button" @click="selectNumber6($event)" value="6">6</button>
            <button v-if="isClicked6" class="button disabled">6</button> <br>
            <button v-if="!isClicked7" class="button" @click="selectNumber7($event)" value="7">7</button>
            <button v-if="isClicked7" class="button disabled">7</button>
            <button v-if="!isClicked8" class="button" @click="selectNumber8($event)" value="8">8</button>
            <button v-if="isClicked8" class="button disabled">8</button>
            <button v-if="!isClicked9" class="button" @click="selectNumber9($event)" value="9">9</button>
            <button v-if="isClicked9" class="button disabled">9</button> <br>
            <button class="button" @click="cancel">취소</button>
            <button class="button" @click="getResult">확인</button> <br>
            {{ playerNumberList }}
        </div>
        <div class="left" align="center">
            <v-list>
                <v-list-item v-for="(round, index) in resultList">
                    <v-list-item-content>
                        <v-list-item-title>
                            {{ round.playerNumberList }} <br>
                            {{ round.result[0] }}
                        </v-list-item-title>
                    </v-list-item-content>
                </v-list-item>
            </v-list> 
        </div>
    </div>
</template>
<script>

export default {
    props: {
        numberCount: {
            type: String,
            required: true
        },
        resultList: Array
    },
    data () {
        return {
            resultList: [],
            playerNumberList: [],
            selectedNumber: 0,
            isClicked1: false,
            isClicked2: false,
            isClicked3: false,
            isClicked4: false,
            isClicked5: false,
            isClicked6: false,
            isClicked7: false,
            isClicked8: false,
            isClicked9: false,
            
        }
    },
    methods: {
        selectNumber1(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked1 = true
            }
        },
        selectNumber2(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked2 = true
            }
        },
        selectNumber3(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked3 = true
            }
        },
        selectNumber4(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked4 = true
            }
        },
        selectNumber5(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked5 = true
            }
        },
        selectNumber6(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked6 = true
            }
        },
        selectNumber7(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked7 = true
            }
        },
        selectNumber8(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked8 = true
            }
        },
        selectNumber9(event) {
            if (this.playerNumberList.length < this.numberCount) {
            this.playerNumberList.push(event.target.value)
            this.isClicked9 = true
            }
        },
        cancel() {
            this.playerNumberList.splice(0)
            this.isClicked1 = false
            this.isClicked2 = false
            this.isClicked3 = false
            this.isClicked4 = false
            this.isClicked5 = false
            this.isClicked6 = false
            this.isClicked7 = false
            this.isClicked8 = false
            this.isClicked9 = false
        },
        async getResult() {
            if (this.playerNumberList.length == this.numberCount) {
            const { playerNumberList } = this;
            this.$emit("submit", {playerNumberList});
            await this.cancel()
            } else {
            alert("숫자가 부족합니다!")
            }

        }
    },
}
</script>

<style>
    .button {
        background-color: blue;

        border: none;

        border-radius: 5px;

        color: white;

        padding: 15px 30px;

        text-align: center;
    }
    .disabled {
        opacity: 0.6;
        cursor: not-allowed;
    }
</style>