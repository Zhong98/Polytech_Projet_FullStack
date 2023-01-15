import { defineStore } from 'pinia'
export const reservation = defineStore('Reserve', {
    state: () => {
        return {
            centerList:[], //resultat de rechercher
            centerSelected: {}, //le center choisi par utilisateur
        }
    },
    getters: {},
})
