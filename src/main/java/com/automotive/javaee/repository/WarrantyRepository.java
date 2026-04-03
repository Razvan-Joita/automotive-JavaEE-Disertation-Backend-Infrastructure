package com.automotive.javaee.repository;

import com.automotive.javaee.model.Warranty;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class WarrantyRepository extends BaseRepository<Warranty> {

    @Inject
    private EntityManager entityManager;

    public WarrantyRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Warranty.class);
    }
}