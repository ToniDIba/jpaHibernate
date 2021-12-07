package com.example.jpaHibernate.persona.application.port;

import com.example.jpaHibernate.persona.domain.Persona;

public interface IBorrarPersona {

    //Cumplimentar la clase ...ExceptionHandler
    public Persona borrarPersonaId(int id) throws Exception;
    public Persona borrarPersona(String name) throws Exception;

}
