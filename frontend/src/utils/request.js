import axios from 'axios';
import {backOfficeMenu} from "@/store/backOfficeMenu.js";
//1. create axios object
const service = axios.create();

//2. request interceptor
service.interceptors.request.use(config => {
    let {token} = backOfficeMenu()
    config.headers.Authorization = token ||'';
    return config;
}, error => {
    Promise.reject(error).then(r => {
    });
});

//3. response interceptor
service.interceptors.response.use(response => {
    return response.data;
},error => {
    return Promise.reject(error);
});

export default service;
