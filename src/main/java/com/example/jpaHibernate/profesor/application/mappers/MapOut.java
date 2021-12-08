package com.example.jpaHibernate.profesor.application.mappers;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.profesor.domain.Profesor;

public class MapOut {


    public Persona mapearSimpleOut(InputDto inputDto) {

        Persona personaOut = new Persona();
      /*
        personaOut.setId_persona(inputDto.getId_persona());
        personaOut.set */

        return personaOut;


    }


}