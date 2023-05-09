<template lang="">
    <div>
        <form @submit.prevent="chooseLevel">
            <legend>숫자 갯수 선택</legend>
            <li>
                <label><input type="radio" name="numberCount" @change="selectNumberCount($event)" value="3">3개</label>
            </li>
            <li>
                <label><input type="radio" name="numberCount" @change="selectNumberCount($event)" value="4">4개</label>
            </li>
            <li>
                <label><input type="radio" name="numberCount" @change="selectNumberCount($event)" value="5">5개</label>
            </li>
            <legend>난이도 선택</legend>
            <li>
                <label><input type="radio" name="level" @change="selectLevel($event)" value="20">easy</label>
            </li>
            <li>
                <label><input type="radio" name="level" @change="selectLevel($event)" value="10">moderate</label>
            </li>
            <li>
                <label><input type="radio" name="level" @change="selectLevel($event)" value="5">hard</label>
            </li>
            <v-btn color="blue" type="submit">선택하기</v-btn>
        </form>
    </div>
</template>
<script>
export default {
    data () {
        return {
            selectedNumberCount: 0,
            selectedLevel: 0
        }
    },
    methods: {
        selectNumberCount(event) {
            this.selectedNumberCount = event.target.value;
            console.log(this.selectedNumberCount)
        },

        selectLevel(event) {
            this.selectedLevel = event.target.value;
            console.log(this.selectedLevel)
        },

        chooseLevel() {
            const {selectNumberCount, selectLevel} = this
            this.$emit('submit', {selectNumberCount, selectLevel})
        }
    }
}
</script>
<style lang="">
    
</style>