package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.model.Actor;
import com.dreamix.movieapi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;

    @GetMapping("/{id}")
    public Actor getActor(@PathVariable long id){
        return actorService.getActor(id);
    }

    @GetMapping("/all")
    public List<Actor> getAllActors(){
        return actorService.getAllActors();
    }

    @PostMapping("/add")
    public Actor addRecord(@RequestBody Actor actor){
        return actorService.addRecord(actor);
    }

    @PutMapping("/update")
    public Actor updateRecord(@RequestBody Actor actor){
        return actorService.updateRecord(actor);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        actorService.deleteRecord(id);
    }
}
