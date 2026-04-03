package com.automotive.javaee.repository;

import com.automotive.javaee.model.Employee;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class EmployeeRepository extends BaseRepository<Employee> {

    @Inject
    private EntityManager entityManager;

    public EmployeeRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Employee.class);
    }
}