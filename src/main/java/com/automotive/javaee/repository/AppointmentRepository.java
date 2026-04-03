package com.automotive.javaee.repository;

import com.automotive.javaee.model.Appointment;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class AppointmentRepository extends BaseRepository<Appointment> {

    @Inject
    private EntityManager entityManager;

    public AppointmentRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Appointment.class);
    }
}