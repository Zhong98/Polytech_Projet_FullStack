package com.polytech.covidapi.service.admin;

import com.polytech.covidapi.entity.Center;
import com.polytech.covidapi.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CRUDCenter {
    @Autowired
    CenterRepository centerRepository;
    public List<Center> getAllCenters(){
        return centerRepository.findAll();
    }

    public boolean createNewCenter(Center center){
        try {
            centerRepository.save(center);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }

    public boolean updateCenter(Center center){
        try {
            centerRepository.save(center);
            return true;
        }catch (Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
}
