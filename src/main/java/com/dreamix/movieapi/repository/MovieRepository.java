package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Movie;
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
public class MovieRepository extends BaseRepository<Movie> {
    @Override
    public Class<Movie> getEntityClass() {
        return Movie.class;
    }

    @Override
    public List<Movie> filterByMap(HashMap<String, Object> filter) {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Movie> criteriaQuery = criteriaBuilder.createQuery(Movie.class);
        Root<Movie> root = criteriaQuery.from(Movie.class);
        List<Predicate> predicates = new ArrayList<>();
        if(filter.get("title") != null){
            predicates.add(criteriaBuilder.like(root.get("title"), "%" + filter.get("title") + "%"));
        }
        if(filter.get("description") != null){
            predicates.add(criteriaBuilder.like(root.get("description"), "%" + filter.get("description") + "%"));
        }
        if(filter.get("runtime") != null){
            predicates.add(criteriaBuilder.le(root.get("runtime"), (int) filter.get("runtime")));
        }
        criteriaQuery.where(criteriaBuilder.or(predicates.toArray(new Predicate[0])));
        TypedQuery<Movie> query = entityManager.createQuery(criteriaQuery);
        return query.getResultList();
    }
}
