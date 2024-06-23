import axios from "axios";

const instance = axios.create({
    baseURL: 'http://localhost:30091/api',
})

export default instance;
