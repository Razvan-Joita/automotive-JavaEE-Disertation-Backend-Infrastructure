package com.automotive.javaee.repository;

import com.automotive.javaee.model.Part;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class PartRepository extends BaseRepository<Part> {

    @Inject
    private EntityManager entityManager;

    public PartRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Part.class);
    }
}