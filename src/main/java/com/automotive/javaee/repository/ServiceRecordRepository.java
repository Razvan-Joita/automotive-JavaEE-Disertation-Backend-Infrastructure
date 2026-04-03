package com.automotive.javaee.repository;

import com.automotive.javaee.model.ServiceRecord;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class ServiceRecordRepository extends BaseRepository<ServiceRecord> {

    @Inject
    private EntityManager entityManager;

    public ServiceRecordRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, ServiceRecord.class);
    }
}