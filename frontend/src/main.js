import { createApp } from 'vue'
import './style.css'
import App from './App.vue'
import router from "./router/index.js";
import store from "@/store/index.js";
import Axios from 'axios';

import "@/assets/css/iconfont.css";
import "@/assets/css/common.css";

import ElementPlus from 'element-plus'
import 'element-plus/dist/index.css'

import fr from 'element-plus/dist/locale/fr.mjs'

const app=createApp(App);
app.config.globalProperties.Axios=Axios
app.use(router).mount('#app')
app.use(ElementPlus, {
    locale: fr,
})
app.use(store)
