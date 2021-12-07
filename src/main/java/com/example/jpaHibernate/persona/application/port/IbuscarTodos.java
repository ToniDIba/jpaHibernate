package com.example.jpaHibernate.persona.application.port;

import com.example.jpaHibernate.persona.domain.Persona;

import java.util.List;

public interface IbuscarTodos {

    public List<Persona> buscarTodos();
}
