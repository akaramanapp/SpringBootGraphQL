package com.graphql.productservice.api;

import com.coxautodev.graphql.tools.GraphQLMutationResolver;
import com.graphql.productservice.dto.VehicleDto;
import com.graphql.productservice.entity.Vehicle;
import com.graphql.productservice.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Save-update operatiopn.
 */
@Component
@RequiredArgsConstructor
public class VehicleMutationResolver implements GraphQLMutationResolver {

    private final VehicleRepository _vehicleRepository;

    public Vehicle createVehicle(VehicleDto vehicleDto){
        return _vehicleRepository.save(dtoToEntity(vehicleDto));
    }

    private Vehicle dtoToEntity(VehicleDto vehicleDto){
        Vehicle vehicle=new Vehicle();
        vehicle.setBrandName(vehicleDto.getBrandName());
        vehicle.setLaunchDate(new Date());
        vehicle.setModelCode(vehicleDto.getModelCode());
        vehicle.setType(vehicleDto.getType());
        return vehicle;
    }
}
