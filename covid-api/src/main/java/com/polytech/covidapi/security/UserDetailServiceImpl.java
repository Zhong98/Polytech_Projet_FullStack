package com.polytech.covidapi.security;

import com.polytech.covidapi.entity.MyUserDetails;
import com.polytech.covidapi.entity.Person;
import com.polytech.covidapi.repository.PeopleRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    PeopleRepository peopleRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        MyUserDetails myUserDetails=new MyUserDetails();
        Person person = peopleRepository.findPersonByEmail(username);
        if (person==null){
            throw new UsernameNotFoundException("L'utilisateur n'existe pas!");
        }
        myUserDetails.setUsername(username);
        myUserDetails.setPassword(person.getPassword());
        return myUserDetails;
    }
}
