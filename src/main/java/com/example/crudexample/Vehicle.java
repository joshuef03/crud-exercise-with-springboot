package com.example.crudexample;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Vehicle {
    private @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    private String description;
    private String registration;
    private String brand;
}
