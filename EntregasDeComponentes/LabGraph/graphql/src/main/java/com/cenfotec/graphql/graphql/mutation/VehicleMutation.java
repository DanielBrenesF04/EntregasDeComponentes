package com.cenfotec.graphql.graphql.mutation;

import com.cenfotec.graphql.graphql.entities.Vehicle;
import com.cenfotec.graphql.graphql.services.VehicleService;
import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDate;

@Component
public class VehicleMutation implements GraphQLMutationResolver {
@Autowired
    private VehicleService vehicleService;
    public Vehicle createVehicle(String type, String modelCode, String brandName,
                                 String launchDate) {
        return this.vehicleService.createVehicle(type, modelCode, brandName, launchDate);
    }
}
