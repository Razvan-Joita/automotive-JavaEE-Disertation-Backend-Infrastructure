package com.automotive.javaee.repository;

import com.automotive.javaee.model.Invoice;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class InvoiceRepository extends BaseRepository<Invoice> {

    @Inject
    private EntityManager entityManager;

    public InvoiceRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, Invoice.class);
    }
}