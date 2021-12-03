package com.example.jpaHibernate.infrastructure.controller.dto.repository.port;

import com.example.jpaHibernate.Persona;
import com.example.jpaHibernate.content.application.port.IbuscarTodos;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
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
