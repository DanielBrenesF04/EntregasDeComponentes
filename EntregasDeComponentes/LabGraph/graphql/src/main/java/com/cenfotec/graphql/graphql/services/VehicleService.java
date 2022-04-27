package com.cenfotec.graphql.graphql.services;

import com.cenfotec.graphql.graphql.entities.Vehicle;
import com.cenfotec.graphql.graphql.repositories.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VehicleService {

    @Autowired
    VehicleRepository vehicleRepo;
    public List<Vehicle> getAllVehicles(int count) {
        return this.vehicleRepo.findAll().stream().limit(count).collect(Collectors.toList());
    }
    public Optional<Vehicle> getVehicle(int id) {
        return this.vehicleRepo.findById(id);
    }
    public Vehicle createVehicle(String type, String modelCode,
                                 String brandName, final String launchDate) {
        Vehicle vehicle = new Vehicle();
        vehicle.setType(type);
        vehicle.setModelCode(modelCode);
        vehicle.setBrandName(brandName);
        vehicle.setLaunchDate(LocalDate.parse(launchDate));
        return this.vehicleRepo.save(vehicle);
    }
}
