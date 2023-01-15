import service from '../request.js'

export function deletePerson(id){
    return service({
        url:'/api/admin/people/deletePerson',
        method:'get',
        params:{id:id}
    })
}
