import service from '../request.js'

export function getPatient(date,centerID,name){
    return service({
        url:'/api/admin/reservation/findReservationByPatient',
        method:'get',
        params: {
            date:date,
            centerID:centerID,
            name:name
        }
    })
}
