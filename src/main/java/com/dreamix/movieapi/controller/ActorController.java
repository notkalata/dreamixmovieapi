package com.dreamix.movieapi.controller;

import com.dreamix.movieapi.converter.ActorConverter;
import com.dreamix.movieapi.dto.ActorDTO;
import com.dreamix.movieapi.service.ActorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/actors")
public class ActorController {
    @Autowired
    private ActorService actorService;
    @Autowired
    private ActorConverter actorConverter;
    @GetMapping("/{id}")
    public ActorDTO getActor(@PathVariable long id){
        if(actorService.getActor(id) == null){
            return null;
        }
        return actorConverter.convertEntityToDto(actorService.getActor(id));
    }
    @GetMapping("/all")
    public List<ActorDTO> getAllActors(){
        return actorService.getAllActors().stream().map(actor -> actorConverter.convertEntityToDto(actor)).collect(Collectors.toList());
    }
    @PostMapping("/add")
    public ActorDTO addRecord(@RequestBody ActorDTO actorDTO){
        return actorConverter.convertEntityToDto(actorService.addRecord(actorConverter.convertDtoToEntity(actorDTO)));
    }
    @PutMapping("/update")
    public ActorDTO updateRecord(@RequestBody ActorDTO actorDTO){
        return actorConverter.convertEntityToDto(actorService.updateRecord(actorConverter.convertDtoToEntity(actorDTO)));
    }
    @DeleteMapping("/delete/{id}")
    public void deleteRecord(@PathVariable long id){
        actorService.deleteRecord(id);
    }
}
