package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.dto.Filter;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
@Repository
public abstract class BaseRepository<T> {
    @PersistenceContext
    protected EntityManager entityManager;
    public abstract Class<T> getEntityClass();
    public List<T> filter(List<Filter> filters){
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> criteriaQuery = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = criteriaQuery.from(getEntityClass());
        List<Predicate> predicates = new ArrayList<>();
        for (Filter filter : filters){
            switch (filter.getOperator()){
                case "like":
                    predicates.add(criteriaBuilder.like(root.get(filter.getName()), "%" + filter.getValue1() + "%"));
                    break;
                case "between":
                    predicates.add(criteriaBuilder.between(root.get(filter.getName()), (int) filter.getValue1(), (int) filter.getValue2()));
                    break;
                case "more":
                    predicates.add(criteriaBuilder.ge(root.get(filter.getName()), (int) filter.getValue1()));
                    break;
                case "less":
                    predicates.add(criteriaBuilder.le(root.get(filter.getName()), (int) filter.getValue1()));
                    break;
                default:
                    System.out.println("Passed not needed argument " + filter.getName());
                    break;
            }
        }
        criteriaQuery.where(criteriaBuilder.and(predicates.toArray(new Predicate[0])));
        TypedQuery<T> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
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


