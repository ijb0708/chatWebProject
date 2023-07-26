import init from "./init";

/**
 * 예제
 * @param
 * @return
 */
export const getReviewById = async () => {
    try {
        const review = await init.get(`/admin/review/detail`);
        console.log(review.data)
        return review.data;
    } catch (e) {
        console.log(e);
    }
}

/**
 * 예제
 * @param
 * @return
 */
export const postLogin = async (userId: string, userPassword: string) => {
    try {
        const isSucc = await init.post(`/user/login`, {
            userId: userId,
            userPassword: userPassword
        });

        console.log(isSucc)
        return isSucc;
    } catch (e) {
        console.log(e);
    }
}
