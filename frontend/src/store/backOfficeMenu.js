import { defineStore } from 'pinia'
export const backOfficeMenu = defineStore('backOfficeMenu', {
    state: () => {
        return {
            pageIndex:'', //Le item selected in backoffice menu
            center:{},//Mettre à jour lors de la connexion en arrière-plan et mettre à jour lorsque le super administrateur clique sur l'icône de la personne sur la page centrale
            person:{},//Mettre à jour lorsque modifier personne
            reservation:{}, //mise à jour lorsque rdv est modifié
            tableData:[],//Toutes les centres
            patientData:[],//Médecin recherche le patient dans la page planning
            userInfo:{}, //Utilisateur
            token:''
        }
    },
    //Enregistre des données dans LocalStorage
    persist: {
        enabled: true,
        strategies: [{
            storage: localStorage,
            paths: ['center', 'person','reservation','userInfo','token']
        }]
    }
})
