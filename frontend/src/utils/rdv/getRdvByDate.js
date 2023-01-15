import service from '../request.js'

export function getRdvByDate(date,centerID){
    return service({
        url:'/api/admin/reservation/findReservationByDate',
        method:'get',
        params: {
            date:date,
            centerID:centerID
        }
    })
}
