import axiosInst from "@/utility/axiosInst";

export default {
  requestCreateAccountToSpring({}, payload) {
    const { email, nickname, password } = payload;
    return axiosInst
      .post("baseball/signup-account", { email, nickname, password })
      .then((res) => {
        if (res.data) {
          alert("가입 성공!");
        } else {
          alert("동일한 계정이 이미 존재합니다");
        }
      });
  },
  requestLoginToSpring({}, payload) {
    const { email, password } = payload;
    return axiosInst
      .post("baseball/login-account", { email, password })
      .then((res) => {
        alert("로그인 성공!");
        let userId = res.data.userId;
        let nickName = res.data.nickName;
        let point = res.data.point;
        localStorage.setItem("loginUserId", userId);
        localStorage.setItem("loginUserNickName", nickName);
        localStorage.setItem("loginUserPoint", point);
      })
      .catch(() => {
        alert("로그인 실패!");
      });
  },
};
