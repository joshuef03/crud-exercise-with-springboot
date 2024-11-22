package com.example.crudexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/vehicles")
public class VehiclesController {
    private final VehiclesRepository vehiclesRepository;

    @Autowired
    VehiclesController(VehiclesRepository repository){
        this.vehiclesRepository = repository;
    }

    @GetMapping
    public List<Vehicles> getAllVehicless(){
        return vehiclesRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicles getOne(@PathVariable Long id){
        return vehiclesRepository.getReferenceById(id);
    }

    @PostMapping()
    public Vehicles newVehicles(@RequestBody Vehicles newVehicles){
        return vehiclesRepository.save(newVehicles);
    }

    @PutMapping("/{id}")
    public Vehicles alterVehicles(@RequestBody Vehicles newVehicles, @PathVariable Long id){
        return vehiclesRepository.findById(id).map(vehicles -> {
           vehicles.setDescription(newVehicles.getDescription());
           vehicles.setRegistration(newVehicles.getRegistration());
           vehicles.setBrand(newVehicles.getBrand());
           return vehiclesRepository.save(vehicles);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteVehicles(@PathVariable Long id){
        vehiclesRepository.deleteById(id);
    }

}
