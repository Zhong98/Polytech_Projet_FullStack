import service from '../request.js'

export function getDoctor(centerID){
    return service({
        url:'/api/admin/people/findDoctor',
        method:'get',
        params: {
            centerID:centerID+''
        }
    })
}
