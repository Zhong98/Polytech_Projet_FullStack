import {createRouter, createWebHistory} from 'vue-router';
import HomePage from '@/views/Public.vue';
import {backOfficeMenu} from "@/store/backOfficeMenu.js";

const routes = [
    {
        path: '/public',
        name: 'Public',
        children: [
            {
                path: '',
                name: 'PublicIndex',
                component: () => import('@/views/public/PublicIndex.vue'),
                meta: {
                    title: 'Vaccination du covid'
                },
            },
            {
                path: 'reserve',
                name: "Reserve",
                component: () => import('@/views/public/Reserve.vue'),
                meta: {
                    title: 'Réserver un rdv'
                },
            }
        ],
        component: HomePage,
    },
    {
        path: '/login',
        name: 'Login',
        component: () => import('@/views/admin/Login.vue'),
        meta: {
            title: 'Merci de connecter'
        },
    },
    {
        path: '/admin',
        name: 'Admin',
        children: [
            {
                path: 'backOffice',
                name: 'BackOffice',
                //Navigation Guards
                beforeEnter: (to, from) => {
                    let {token} = backOfficeMenu();
                    if (!token) {
                        return {name: 'Login'}
                    }else {
                        return true;
                    }
                },
                children: [
                    {
                        path: '',
                        name: 'Default',
                        component: () => import('@/views/admin/Default.vue'),
                    },
                    {
                        path: 'centerList',
                        name: 'CenterList',
                        component: () => import('@/views/admin/CenterList.vue'),
                        beforeEnter: (to, from) => {
                            let {userInfo} = backOfficeMenu();
                            if (userInfo.role != 0) {  //Juste super dmin
                                return false
                            }
                        },
                    },
                    {
                        path: 'myCenter',
                        name: 'MyCenter',
                        component: () => import('@/views/admin/MyCenter.vue'),
                        beforeEnter: (to, from) => {
                            let {userInfo} = backOfficeMenu();
                            if (userInfo.role != 0 && userInfo.role != 1) { //Juste admin et super admin peuvent regarder cette page
                                return false
                            }
                        },
                    },
                    {
                        path: 'planning',
                        name: 'Planning',
                        component: () => import('@/views/admin/Planning.vue'),
                    },
                    {
                        path: 'superAdmin',
                        name: 'SuperAdmin',
                        component: () => import('@/views/admin/SuperAdmin.vue'),
                        beforeEnter: (to, from) => {
                            let {userInfo} = backOfficeMenu();
                            if (userInfo.role != 0) {
                                return false
                            }
                        },
                    },
                    {
                        path: 'centerModify',
                        name: 'CenterModify',
                        component: () => import('@/views/admin/actions/CenterModify.vue'),
                        beforeEnter: (to, from) => {
                            let {userInfo} = backOfficeMenu();
                            if (userInfo.role != 0) {
                                return false
                            }
                        },
                    },
                    {
                        path: 'personModify',
                        name: 'PersonModify',
                        component: () => import('@/views/admin/actions/PersonModify.vue'),
                        beforeEnter: (to, from) => {
                            let {userInfo} = backOfficeMenu();
                            if (userInfo.role != 0 && userInfo.role != 1) {
                                return false
                            }
                        },
                    },
                    {
                        path: 'adminReserve',
                        name: 'AdminReserve',
                        component: () => import('@/views/admin/actions/AdminReserve.vue'),
                        beforeEnter: (to, from) => {
                            let {userInfo} = backOfficeMenu();
                            if (userInfo.role != 0 && userInfo.role != 1) {
                                return false
                            }
                        },
                    },
                ],
                component: () => import('@/views/admin/BackOfficeIndex.vue'),
                meta: {
                    title: 'Bienvenu chez back office'
                },
            },
        ],
        component: () => import("@/views/Admin.vue"),
    },
    {
        path: '/wait',
        name: 'Wait',
        component: () => import("@/views/WaitingRoom.vue"),
        meta: {
            title: "File d’attente"
        },
    },
    //Redirect URL
    {
        path: '/',
        redirect: '/public'
    }
]

const router = createRouter({
    history: createWebHistory(),
    routes
})

router.beforeEach((to, from, next) => {
    document.title = to.meta.title ? to.meta.title : 'defaultTitle'
    next()
})
export default router
