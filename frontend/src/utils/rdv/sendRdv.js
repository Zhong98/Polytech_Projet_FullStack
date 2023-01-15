import service from '../request.js'

export function sendRdv(reservation){
    return service({
        url:'/api/public/reserve',
        method:'post',
        data:reservation
    })
}
