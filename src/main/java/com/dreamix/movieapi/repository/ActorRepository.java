package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Actor;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class ActorRepository extends BaseRepository<Actor> {
    @Override
    public Class<Actor> getEntityClass() {
        return Actor.class;
    }

    @Override
    public List<Actor> filterByMap(HashMap<String, Object> filter) {
        return null;
    }
}
