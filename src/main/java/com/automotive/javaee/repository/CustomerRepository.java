package com.automotive.javaee.repository;

import com.automotive.javaee.model.Customer;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class CustomerRepository extends BaseRepository<Customer> {

    @Inject
    private EntityManager entityManager;

    public CustomerRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Customer.class);
    }
}