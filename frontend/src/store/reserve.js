import { defineStore } from 'pinia'
export const reservation = defineStore('Reserve', {
    state: () => {
        return {
            centerSelected: {}, //用户选择的时候更新
        }
    },
    getters: {},
})
