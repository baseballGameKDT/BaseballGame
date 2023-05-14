import axiosInst from "@/utility/axiosInst";

export default {
    requestCreateAccountToSpring({}, payload) {
        const { email, nickname, password } = payload;
        return axiosInst.post("baseball/signup-account", { email, nickname, password })
        .then((res) => {
            if (res.data) {
                alert('가입 성공!')
            } else {
                alert('동일한 계정이 이미 존재합니다')
            }
        })
    },
}