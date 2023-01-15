import service from '../request.js'

export function getCenterList(data){
    if (data==null){
        return service({
            url:'/api/admin/center/centerList',
            method:"post"
        })
    }else{
        return service({
            url:'/api/public/search',
            method:'get',
            params:{
                centerInfo:data
            }
        })
    }
}
