package com.automotive.javaee.repository;

import com.automotive.javaee.model.BaseEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityNotFoundException;

import java.util.List;
import java.util.Optional;

public abstract class BaseRepository<T extends BaseEntity> {

    protected EntityManager entityManager;
    private Class<T> entityClass;

    protected BaseRepository() {
    }

    protected void init(EntityManager entityManager, Class<T> entityClass) {
        this.entityManager = entityManager;
        this.entityClass = entityClass;
    }

    public List<T> findAll() {
        return entityManager
                .createQuery("select e from " + entityClass.getSimpleName() + " e", entityClass)
                .getResultList();
    }

    public Optional<T> findById(Long id) {
        return Optional.ofNullable(entityManager.find(entityClass, id));
    }

    public T save(T entity) {
        entityManager.getTransaction().begin();
        try {
            if (entity.getId() == null) {
                entityManager.persist(entity);
            } else {
                entity = entityManager.merge(entity);
            }
            entityManager.getTransaction().commit();
            return entity;
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw ex;
        }
    }

    public void delete(Long id) {
        T entity = entityManager.find(entityClass, id);
        if (entity == null) {
            throw new EntityNotFoundException(entityClass.getSimpleName() + " not found");
        }

        entityManager.getTransaction().begin();
        try {
            entityManager.remove(entity);
            entityManager.getTransaction().commit();
        } catch (Exception ex) {
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            throw ex;
        }
    }
}