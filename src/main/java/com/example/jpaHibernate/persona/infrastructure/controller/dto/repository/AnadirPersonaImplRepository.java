package com.example.jpaHibernate.persona.infrastructure.controller.dto.repository;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.application.port.IanadirPersona;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AnadirPersonaImplRepository implements IanadirPersona
{
    @Autowired
    IvalidacionesService validacionesService;

    @Autowired
    IpersonaRepositorio personaRepositorio;


    @Override
    public void anyadirPersona(Persona pers) {

        validacionesService.validarInfoPersona(pers);
         personaRepositorio.save(pers);


    }




}
