package com.polytech.covidapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "center")
public class Center {
    @Id
    private Long id;
    private String name;
    private String zipcode;
    private String city;
    private String address;

}
