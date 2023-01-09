import {createRouter, createWebHistory} from 'vue-router';
import Home from '@/views/Home.vue'
const routes =[
    {
        path:'/home',
        name:'Home',
        children:[
            {
                path: '',
                name: 'Home',
                component: Home,
                meta:{
                    title:'Vaccination du covid'
                },
            },
            {
                path:'/reserve',
                name:"Reserve",
                component: () => import('@/views/home/Reserve.vue'),
                meta:{
                    title:'Réserver un rdv'
                },
            }
        ]
    },
    {
        path: '/',
        redirect:'/home'
    },
    {
        path:'/admin',
        name:'Admin',
        component: ()=> import("@/views/Admin.vue"),
        meta:{
            title:'Back office'
        }
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
