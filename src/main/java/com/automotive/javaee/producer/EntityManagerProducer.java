
package com.automotive.javaee.producer;

import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.HashMap;
import java.util.Map;

@ApplicationScoped
public class EntityManagerProducer {

    private final EntityManagerFactory emf;

    public EntityManagerProducer() {
        Map<String, Object> props = new HashMap<>();
        props.put("jakarta.persistence.jdbc.url",
                System.getenv().getOrDefault("DB_URL", "jdbc:mysql://mysql:3306/automotiveJavaEE?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC"));
        props.put("jakarta.persistence.jdbc.user",
                System.getenv().getOrDefault("DB_USER", "automotive"));
        props.put("jakarta.persistence.jdbc.password",
                System.getenv().getOrDefault("DB_PASSWORD", "Jabulani2002@"));
        props.put("jakarta.persistence.jdbc.driver", "com.mysql.cj.jdbc.Driver");
        this.emf = Persistence.createEntityManagerFactory("automotivePU", props);
    }

    @Produces
    @RequestScoped
    public EntityManager produceEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager entityManager) {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    @PreDestroy
    public void shutdown() {
        if (emf.isOpen()) {
            emf.close();
        }
    }
}
