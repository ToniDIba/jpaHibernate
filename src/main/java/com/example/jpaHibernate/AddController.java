package com.example.jpaHibernate;

import com.example.jpaHibernate.content.application.port.IanadirPersona;
import com.example.jpaHibernate.content.application.port.IbuscarTodos;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
import com.example.jpaHibernate.content.application.port.IvalidacionesService;
import com.example.jpaHibernate.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.infrastructure.controller.dto.output.DatosPersonaDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


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

