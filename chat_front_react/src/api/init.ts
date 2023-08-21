import axios from "axios";

const init = axios.create({
    baseURL : "http://localhost:8080"
});

export default init;