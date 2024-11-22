package com.example.crudexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController @RequestMapping("/vehicle")
public class VehicleController {
    private final VehicleRepository vehicleRepository;

    @Autowired
    VehicleController(VehicleRepository repository){
        this.vehicleRepository = repository;
    }

    @GetMapping
    public List<Vehicle> getAllVehicles(){
        return vehicleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Vehicle getOne(@PathVariable Long id){
        return vehicleRepository.getReferenceById(id);
    }

    @PostMapping()
    public Vehicle newVehicle(@RequestBody Vehicle newVehicle){
        return vehicleRepository.save(newVehicle);
    }

    @PutMapping("/{id}")
    public Vehicle alterVehicle(@RequestBody Vehicle newVehicle, @PathVariable Long id){
        return vehicleRepository.findById(id).map(vehicle -> {
           vehicle.setDescription(newVehicle.getDescription());
           vehicle.setRegistration(newVehicle.getRegistration());
           vehicle.setBrand(newVehicle.getBrand());
           return vehicleRepository.save(vehicle);
        }).orElseThrow();
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id){
        vehicleRepository.deleteById(id);
    }

}
