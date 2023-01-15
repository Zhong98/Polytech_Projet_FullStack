import service from '../request.js'

export function getRdvByCenter(centerID){
    return service({
        url:'/api/admin/reservation/findReservationByCenter',
        method:'get',
        params: {centerID:centerID}
    })
}
