package com.example.jpaHibernate.content.application.port;

import com.example.jpaHibernate.Persona;

public interface IBuscarPersona {

    public Persona buscarPersona(String name);

    public Persona buscarPersonaId(String id) throws Exception;



}
