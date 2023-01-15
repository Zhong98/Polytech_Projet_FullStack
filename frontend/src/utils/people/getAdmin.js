import service from '../request.js'

export function getAdmin(){
    return service({
        url:'/api/admin/people/findAdmin',
        method:'get',
    })
}
