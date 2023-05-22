import axiosInst from "@/utility/axiosInst";

export default {
  sendGameLevelToSpring({}, payload) {
    const { numberCount, level, point } = payload;

    return axiosInst
      .post("/baseball/choose-level", { numberCount, level, point })
      .then((res) => {
        alert("난이도 선택 완료");
      })
      .catch(() => {
        alert("문제 발생!");
      });
  },
  requestGameResultToSpring({}, payload) {
    const { playerNumberList } = payload;

    return axiosInst
      .post("baseball/get-result", { playerNumberList })
      .then((res) => {
        console.log(res.data);
        return res.data;
      });
  },
};
