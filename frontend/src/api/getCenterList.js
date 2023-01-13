import service from './/request'

export function getCenterList(data ){
    if (data==null){
        return service({
            url:'/api/admin/centerList',
            method:"post"
        })
    }else{
        return service({
            url:'/api/public/centerList',
            method:"post",
            data
        })
    }
}
