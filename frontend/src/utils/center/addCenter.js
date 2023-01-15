import service from '../request.js'

export function addCenter(center){
    return service({
        url:'/api/admin/center/addCenter',
        method:'post',
        data:center
    })
}
