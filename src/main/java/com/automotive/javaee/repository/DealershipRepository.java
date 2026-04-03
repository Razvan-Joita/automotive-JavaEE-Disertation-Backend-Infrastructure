package com.automotive.javaee.repository;

import com.automotive.javaee.model.Dealership;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class DealershipRepository extends BaseRepository<Dealership> {

    @Inject
    private EntityManager entityManager;

    public DealershipRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Dealership.class);
    }
}