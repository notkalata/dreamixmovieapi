package com.dreamix.movieapi.repository;

import com.dreamix.movieapi.model.User;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository extends BaseRepository<User> {
    @Override
    public Class<User> getEntityClass() {
        return User.class;
    }
}
