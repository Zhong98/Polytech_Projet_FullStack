import service from '../request.js'

export function updatePerson(person){
    return service({
        url:'/api/admin/people/addOrUpdatePerson',
        method:'post',
        data:person
    })
}
