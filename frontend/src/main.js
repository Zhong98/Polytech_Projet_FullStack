import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router/index.js";

import "@/assets/css/iconfont.css";
import "@/assets/css/common.css";

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

const app=createApp(App);
app.use(router).mount('#app')
app.use(ElementPlus)
