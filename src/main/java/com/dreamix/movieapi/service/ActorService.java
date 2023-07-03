package com.dreamix.movieapi.service;

import com.dreamix.movieapi.model.Actor;
import com.dreamix.movieapi.repository.ActorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorService {
    @Autowired
    private ActorRepository actorRepository;
    public Actor getActor(long id){
        return actorRepository.findById(id);
    }
    public List<Actor> getAllActors(){
        return actorRepository.findAll();
    }
    public Actor addRecord(Actor actor){
        return actorRepository.create(actor);
    }
    public Actor updateRecord(Actor actor){
        return actorRepository.update(actor);
    }
    public void deleteRecord(long id){
        actorRepository.delete(id);
    }
}
