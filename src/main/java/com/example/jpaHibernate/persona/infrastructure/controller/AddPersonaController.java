package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.application.port.IanadirPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class AddPersonaController {


    @Autowired
    IvalidacionesService validacionesService;

    @Autowired
    IanadirPersona anadirPersona;


    @PostMapping("/add/addPersona")
    public Persona anadirPersona(@RequestBody InputDto inputDto) {

        Persona miPers=new Persona();

        System.out.println("                      Token: " + ValidacionesServiceImpl.token);
        System.out.println("Desde AddPersona. Soy Admin: " + LoginController.esAdmin);

        if(LoginController.esAdmin) {
            miPers = validacionesService.mapearInputOutput(inputDto);
            anadirPersona.anyadirPersona(miPers); //Hace un Repository.add
        } else {
            miPers.setName("No eres 'Admin'. Sólo puedes hacer consultas");
        }

        return miPers;


    }


}

