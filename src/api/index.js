import customAxios from '@/api/axiosInit'

/**
 * 어드민 후기 단건 조회
 * @param {*} id 아이디
 * @returns
 */
export const getReviewById = async id => {
  try {
    const review = await customAxios.get(`/admin/review/detail?id=${id}`);
    console.log(review.data)
    return review.data;
  } catch (e) {
    console.log(e);
  }
}

