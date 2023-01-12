package com.uniyaz.sakila.core.actor;


import com.uniyaz.sakila.core.actor.domain.Actor;
import com.uniyaz.sakila.core.country.CountryDto;
import com.uniyaz.sakila.core.country.domain.Country;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class ActorConverter {

    public ActorDto convertToActorDto(Actor actor){
        ActorDto actorDto=new ActorDto();
        actorDto.setId(actor.getId());
        actorDto.setFirstName(actor.getFirstName());
        return actorDto;
    }

    public List<ActorDto> convertToActorDtoList(List<Actor> actorList){
        List<ActorDto> actorDtoList=new ArrayList<>();

        for (Actor actor : actorList){
            ActorDto actorDto=convertToActorDto(actor);
            actorDtoList.add(actorDto);
        }
        return actorDtoList;
    }
}
