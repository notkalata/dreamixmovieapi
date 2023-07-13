package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.User;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class UserRepository extends BaseRepository<User> {
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
    @Override
    public List<User> filterByMap(HashMap<String, Object> filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> criteriaQuery = criteriaBuilder.createQuery(User.class);
        Root<User> root = criteriaQuery.from(User.class);
        List<Predicate> predicates = new ArrayList<>();
        if(filter.get("username") != null){
            predicates.add(criteriaBuilder.like(root.get("username"), "%" + filter.get("username") + "%"));
        }
        if(filter.get("firstName") != null){
            predicates.add(criteriaBuilder.like(root.get("firstName"), "%" + filter.get("firstName") + "%"));
        }
        if(filter.get("lastName") != null){
            predicates.add(criteriaBuilder.like(root.get("lastName"), "%" + filter.get("lastName") + "%"));
        }
        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
        TypedQuery<User> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
