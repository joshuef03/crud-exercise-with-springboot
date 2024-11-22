package com.example.crudexample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Vehicles {
    private @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    private String descriptions;
    private String registrations;
    private String brands;
}
