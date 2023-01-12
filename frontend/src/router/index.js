import {createRouter, createWebHistory} from 'vue-router';
import HomePage from '@/views/Public.vue';

const routes =[
    {
        path:'/public',
        name:'Public',
        children:[
            {
                path: '',
                name: 'PublicIndex',
                component: () => import('@/views/public/PublicIndex.vue'),
                meta:{
                    title:'Vaccination du covid'
                },
            },
            {
                path:'reserve',
                name:"Reserve",
                component: () => import('@/views/public/Reserve.vue'),
                meta:{
                    title:'Réserver un rdv'
                },
            }
        ],
        component: HomePage,
    },
    {
        path:'/admin',
        name:'Admin',
        children: [
            {
                path:'',
                name:'Login',
                component: () => import('@/views/admin/Login.vue'),
                meta:{
                    title: 'Merci de connecter'
                },
            },
            {
                path:'backOffice',
                name:'BackOffice',
                children:[
                    {
                        path:'',
                        name:'Default',
                        component: () => import('@/views/admin/Default.vue'),
                    },
                    {
                        path:'centerList',
                        name:'CenterList',
                        component: () => import('@/views/admin/CenterList.vue'),
                    },
                    {
                        path:'myCenter',
                        name:'MyCenter',
                        component: () => import('@/views/admin/MyCenter.vue'),
                    },
                    {
                        path: 'planning',
                        name:'Planning',
                        component: () => import('@/views/admin/Planning.vue'),
                    },
                    {
                        path:'superAdmin',
                        name:'SuperAdmin',
                        component: () => import('@/views/admin/SuperAdmin.vue'),
                    },
                    {
                        path:'centerModify',
                        name:'CenterModify',
                        component: () => import('@/views/admin/actions/CenterModify.vue'),
                    },
                    {
                        path:'personModify',
                        name:'PersonModify',
                        component: () => import('@/views/admin/actions/PersonModify.vue'),
                    },
                    {
                        path: 'adminReserve',
                        name:'AdminReserve',
                        component: () => import('@/views/admin/actions/AdminReserve.vue'),
                    },
                ],
                component: () => import('@/views/admin/BackOfficeIndex.vue'),
                meta:{
                    title: 'Bienvenu chez back office'
                },
            },
        ],
        component: ()=> import("@/views/Admin.vue"),
    },

    //Redirect URL
    {
        path: '/',
        redirect:'/public'
    }
]

const router = createRouter({
    history:createWebHistory(),
    routes
})

router.beforeEach((to, from, next)=>{
    document.title = to.meta.title ? to.meta.title : defaultTitle
    next()
})
export default router
