<template lang="">
  <div>
    <form @submit.prevent="chooseLevel">
      <div align="center">
        <legend>난이도 선택</legend>
        <v-btn color="green" @click="easyLevel">easy</v-btn>
        <v-btn color="blue" @click="normalLevel">normal</v-btn>
        <v-btn color="red" @click="hardLevel">hard</v-btn>
      </div>
      <div class="bet" align="left">
        현재 포인트: {{ currentPoint }} <br />
        베팅 금액:
        <input type="number" v-model="point" /> <br />
        {{ selectedLevel }} <br />
      </div>
      <v-btn color="grey" type="submit">선택하기</v-btn>
    </form>
  </div>
</template>
<script>
export default {
  data() {
    return {
      numberCount: 0,
      level: 0,
      point: 0,
      currentPoint: parseInt(localStorage.getItem("loginUserPoint")),
      selectedLevel: "",
      user_id: localStorage.getItem("loginUserId")
    };
  },
  methods: {
    easyLevel() {
      this.level = 10;
      this.numberCount = 3;
      this.selectedLevel = "easy (숫자 3개, 10라운드)";
    },
    normalLevel() {
      this.level = 20;
      this.numberCount = 4;
      this.selectedLevel = "normal (숫자 4개, 20라운드)";
    },
    hardLevel() {
      this.level = 10;
      this.numberCount = 4;
      this.selectedLevel = "hard (숫자 4개, 10라운드)";
    },

    chooseLevel() {
      if (this.point < this.currentPoint) {
        const { numberCount, level, point, user_id } = this;
        this.$emit("submit", { numberCount, level, point, user_id });
      } else {
        alert("포인트가 부족합니다.");
      }
    },
  },
};
</script>
<style scoped>
div {
  margin: 10px;
}
.bet {
  box-sizing: content-box;
  width: 300px;
  height: 30px;
  margin: 10px;
  padding: 30px;
}
</style>
