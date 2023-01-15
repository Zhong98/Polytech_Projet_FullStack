import service from '../request.js'

export function deleteRdv(id){
    return service({
        url:'/api/admin/reservation/deleteReservation',
        method:'get',
        params:{id:id}
    })
}
