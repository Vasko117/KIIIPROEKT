import axios from "axios";

const instance = axios.create({
    baseURL: process.env.REACT_APP_BACKEND_URL || 'http://localhost:9091/api' || 'http://backend:9091/api',})

export default instance;
