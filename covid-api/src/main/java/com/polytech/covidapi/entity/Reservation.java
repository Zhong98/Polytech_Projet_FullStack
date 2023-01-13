package com.polytech.covidapi.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "reservation")
public class Reservation {
    @Id
    private Long id;
    private String firstname;
    private String lastname;
    private String email;
    private int centerID;
    private String date;
    private int status;
}
