package com.example.jpaHibernate.infrastructure.controller.dto.repository.port;

import com.example.jpaHibernate.Persona;
import com.example.jpaHibernate.content.application.port.IanadirPersona;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
import com.example.jpaHibernate.content.application.port.IvalidacionesService;
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
