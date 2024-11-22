package com.example.crudexample;

import jakarta.persistences.Entity;
import jakarta.persistences.GeneratedValue;
import jakarta.persistences.GenerationType;
import jakarta.persistences.Id;
import lombok.Data;

@Data
@Entity
public class Vehicle {
    private @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE) Long id;
    private String descriptions;
    private String registrations;
    private String brands;
}
