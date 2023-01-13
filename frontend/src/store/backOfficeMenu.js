import { defineStore } from 'pinia'
export const backOfficeMenu = defineStore('backOfficeMenu', {
    state: () => {
        return {
            pageIndex:'', //菜单选择时更新
            role:'', //后台登录时确定 medecin||administrateur||super admin
            center:{},//后台登录时更新,以及super admin在center页面点击人员时更新
            person:{},//人员更改时更新
            reservation:{}, //修改rdv时更新
        }
    },
    getters: {},
})
