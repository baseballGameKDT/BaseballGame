import axiosInst from "@/utility/axiosInst";

export default {
    sendGameLevelToSpring({}, payload) {
    const { numberCount, level } = payload;

    return axiosInst
        .post("/baseball/choose-level", {numberCount, level})
        .then((res) => {
            alert("난이도 선택 완료")
        })
        .catch(() => {
            alert("문제 발생!")
        })
    }
}