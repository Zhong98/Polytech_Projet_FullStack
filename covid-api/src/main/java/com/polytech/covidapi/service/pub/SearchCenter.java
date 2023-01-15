package com.polytech.covidapi.service.pub;

import com.polytech.covidapi.entity.Center;
import com.polytech.covidapi.repository.CenterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchCenter {
    @Autowired
    CenterRepository centerRepository;

    public List<Center> getCenters(String cityOrZIPcode){
        try{
            int zipcode=Integer.parseInt(cityOrZIPcode);
            List<Center> centersByZipcode = centerRepository.findCentersByZipcode(zipcode+"");
            return centersByZipcode;
        }catch (Exception e){
            List<Center> centersByCityLike = centerRepository.findCentersByCityLike("%" + cityOrZIPcode + "%");
            return centersByCityLike;
        }
    }
}
