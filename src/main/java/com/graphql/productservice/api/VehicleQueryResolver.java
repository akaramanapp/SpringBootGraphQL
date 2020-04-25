package com.graphql.productservice.api;

import com.coxautodev.graphql.tools.GraphQLQueryResolver;
import com.graphql.productservice.entity.Vehicle;
import com.graphql.productservice.repo.VehicleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class VehicleQueryResolver implements GraphQLQueryResolver {

    private final VehicleRepository _vehicleRepository;

    public List<Vehicle> getVehicles(String type) {
        return _vehicleRepository.getByTypeLike(type);
    }

    public Optional<Vehicle> getById(Long id) {
        return _vehicleRepository.findById(id);
    }
}
