import service from './/request'

export function checkAuth(data ){
    return service({
        url:'/api/admin/user',
        method:"post",
        data
    })
}
