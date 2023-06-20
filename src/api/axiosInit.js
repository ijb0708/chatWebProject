import axios from "axios";

export default customAxios = axios.create({
  baseURL: process.env.API_URL
  // baseURL: "http://localhost:8585"
})