package com.polytech.covidapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Account {
    private Person person;
    private String token;
    private Center center;
    public Account(Person person,String token){
        this.person=person;
        this.token=token;
    }
}
