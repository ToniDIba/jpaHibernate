package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.application.port.IanadirPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddController {


    @Autowired
    IvalidacionesService validacionesService;

    @Autowired
    IanadirPersona anadirPersona;


    @PostMapping
    public Persona anadirPersona(@RequestBody InputDto inputDto) {

        Persona miPers = validacionesService.mapearInputOutput(inputDto);
        anadirPersona.anyadirPersona(miPers); //Hace un Repository.add
        return miPers;
    }





}

