package com.automotive.javaee.repository;

import com.automotive.javaee.model.Vehicle;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class VehicleRepository extends BaseRepository<Vehicle> {

    @Inject
    private EntityManager entityManager;

    public VehicleRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Vehicle.class);
    }
}