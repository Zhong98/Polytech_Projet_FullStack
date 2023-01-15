import service from '../request.js'

export function getSuperAdmin(){
    return service({
        url:'/api/admin/people/findSuperAdmin',
        method:'get',
    })
}
