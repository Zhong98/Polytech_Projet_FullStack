import service from '../request.js'

export function updateRdv(reservation){
    return service({
        url:'/api/admin/reservation/updateReservation',
        method:'post',
        data:reservation
    })
}
