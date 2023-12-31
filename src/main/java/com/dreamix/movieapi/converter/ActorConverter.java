package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.ActorDTO;
import com.dreamix.movieapi.model.Actor;
import com.dreamix.movieapi.service.ActorService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActorConverter {
    @Autowired
    private ActorService actorService;
    public ActorDTO convertEntityToDto(Actor actor){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(actor, ActorDTO.class);
    }
    public Actor convertDtoToEntity(ActorDTO actorDTO){
        ModelMapper modelMapper = new ModelMapper();
        Actor map = modelMapper.map(actorDTO, Actor.class);
        if(actorDTO.getId() != null){
            Actor existing = actorService.getActor(actorDTO.getId());
            map.updateFrom(existing);
        }
        return map;
    }
}
