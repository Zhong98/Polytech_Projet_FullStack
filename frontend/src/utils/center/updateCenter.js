import service from '../request.js'

export function updateCenter(center){
    return service({
        url:'/api/admin/center/updateCenter',
        method:'post',
        data:center
    })
}
