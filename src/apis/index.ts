import api from "./api";

/**
 * 예제
 * @param
 * @return
 */
export const getReviewById = async () => {
    try {
        const review = await api.get(`/admin/review/detail`);
        console.log(review.data)
        return review.data;
    } catch (e) {
        console.log(e);
    }
}

