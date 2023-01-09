package com.example.covidapi.controller;

import org.hibernate.dialect.PostgresPlusDialect;
import org.springframework.beans.factory.annotation.Autowired;

public class MyController {

    @Autowired
    PostgresPlusDialect pr;
}
