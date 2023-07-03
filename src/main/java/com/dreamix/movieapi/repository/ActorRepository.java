package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.Actor;
import org.springframework.stereotype.Repository;

@Repository
public class ActorRepository extends BaseRepository<Actor> {
    @Override
    public Class<Actor> getEntityClass() {
        return Actor.class;
    }
}
