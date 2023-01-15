package com.polytech.covidapi.security;

import com.alibaba.fastjson2.JSONObject;
import com.polytech.covidapi.entity.Account;
import com.polytech.covidapi.entity.Center;
import com.polytech.covidapi.entity.Person;
import com.polytech.covidapi.repository.CenterRepository;
import com.polytech.covidapi.repository.PeopleRepository;
import com.polytech.covidapi.utils.JWTTokenUtil;
import io.github.bucket4j.Bandwidth;
import io.github.bucket4j.Bucket;
import io.github.bucket4j.ConsumptionProbe;
import io.github.bucket4j.Refill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.time.Duration;

@RestController
public class LoginController {
    @Autowired
    UserDetailsService userDetailsService;
    @Autowired
    PeopleRepository peopleRepository;
    @Autowired
    CenterRepository centerRepository;
    Refill refill = Refill.intervally(10, Duration.ofMinutes(1));
    Bandwidth limit = Bandwidth.classic(10, refill);
    Bucket bucket = Bucket.builder().addLimit(limit).build();
    @GetMapping("/login")
    @ResponseBody
    public String Login(String username,String password){
        ConsumptionProbe probe = bucket.tryConsumeAndReturnRemaining(1);
        if (probe.isConsumed()) {
            if (bucket.tryConsume(1)) {
                UserDetails userDetails = userDetailsService.loadUserByUsername(username);
                if (password.equals(userDetails.getPassword())) {
                    Person person = peopleRepository.findPersonByEmail(username);
                    String token = JWTTokenUtil.createToken(person.getId() + "", person.getRole() + "");
                    Account account;
                    if (person.getCenterID() == null) {
                        account = new Account(person, token);
                    } else {
                        Center center = centerRepository.findCenterById(Integer.parseInt(person.getCenterID()));
                        account = new Account(person, token, center);
                    }
                    return JSONObject.toJSONString(account);
                } else {
                    return "0";
                }
            }
        }
        return "Too many request";
    }
}
