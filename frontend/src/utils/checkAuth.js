import service from './request'

export function checkAuth(email,password){
    return service({
        url:'/api/login',
        method:"get",
        params:{
            username:email,
            password:password
        }
    })
}
