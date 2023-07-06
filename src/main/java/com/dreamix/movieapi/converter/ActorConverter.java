package com.dreamix.movieapi.converter;

import com.dreamix.movieapi.dto.ActorDTO;
import com.dreamix.movieapi.model.Actor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class ActorConverter {
    public ActorDTO convertEntityToDto(Actor actor){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(actor, ActorDTO.class);
    }
    public Actor convertDtoToEntity(ActorDTO actorDTO){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(actorDTO, Actor.class);
    }
}
