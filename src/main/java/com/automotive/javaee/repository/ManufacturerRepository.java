package com.automotive.javaee.repository;

import com.automotive.javaee.model.Manufacturer;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class ManufacturerRepository extends BaseRepository<Manufacturer> {

    @Inject
    private EntityManager entityManager;

    public ManufacturerRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Manufacturer.class);
    }
}