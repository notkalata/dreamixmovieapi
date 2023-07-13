package com.dreamix.movieapi.repository;

import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@Repository
public abstract class BaseRepository<T> {
    @PersistenceContext
    protected EntityManager entityManager;
    public abstract Class<T> getEntityClass();
    public abstract List<T> filterByMap(HashMap<String, Object> filter);
    public T findById(long id){
        return entityManager.find(getEntityClass(), id);
    }
    public List<T> findAll(){
        return entityManager.createQuery("from " + getEntityClass().getSimpleName()).getResultList();
    }
    @Transactional
    public T create(T object){
        entityManager.persist(object);
        return object;
    }
    @Transactional
    public T update(T object){
        entityManager.merge(object);
        return object;
    }
    @Transactional
    public void delete(long id) {
        entityManager.remove(findById(id));
    }
}


