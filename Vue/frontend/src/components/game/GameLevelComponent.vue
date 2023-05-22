<template lang="">
  <div>
    <div align="center">
      <legend>숫자 갯수 선택</legend>
      <v-btn color="green" @click="easyLevel">easy</v-btn>
      <v-btn color="blue" @click="normalLevel">normal</v-btn>
      <v-btn color="red" @click="hardLevel">hard</v-btn>
    </div>
    {{ selectedLevel }} <br />
    <v-btn color="grey" @click="chooseLevel">선택하기</v-btn>
  </div>
</template>
<script>
export default {
  data() {
    return {
      numberCount: 0,
      level: 0,
      selectedLevel: "",
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
        const { numberCount, level, point } = this;
        this.$emit("submit", { numberCount, level, point });
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
</style>
