package com.example.jpaHibernate.persona.infrastructure.controller.dto.repository;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.application.port.IbuscarTodos;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuscarTodosImplRepository implements IbuscarTodos {

    @Autowired
    IpersonaRepositorio personaRepositorio;



    @Override
    public List<Persona> buscarTodos() {
        return personaRepositorio.findAll();
    }
}
