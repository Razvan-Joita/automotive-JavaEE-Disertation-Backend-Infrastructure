package com.automotive.javaee.repository;

import com.automotive.javaee.model.User;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;

@RequestScoped
public class UserRepository extends BaseRepository<User> {

    @Inject
    private EntityManager entityManager;

    public UserRepository() {
    }

    @PostConstruct
    void initRepository() {
        init(entityManager, User.class);
    }
}