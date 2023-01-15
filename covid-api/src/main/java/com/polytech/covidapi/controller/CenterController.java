package com.polytech.covidapi.controller;

import com.polytech.covidapi.entity.Center;
import com.polytech.covidapi.service.admin.CRUDCenter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/admin/center")
public class CenterController {

    @Autowired
    CRUDCenter crudCenter;
    @RequestMapping("/centerList")
    @ResponseBody
    public List<Center> findAllCenters(){
        return crudCenter.getAllCenters();
    }

    @PostMapping("/addCenter")
    @ResponseBody
    public int addCenter(@RequestBody Center center){
        boolean newCenter = crudCenter.createNewCenter(center);
        if (newCenter) return 200;
        else return 400;
    }

    @PostMapping("/updateCenter")
    @ResponseBody
    public int modifyCenter(@RequestBody Center center){
        boolean b = crudCenter.updateCenter(center);
        if (b) return 200;
        else return 400;
    }
}
