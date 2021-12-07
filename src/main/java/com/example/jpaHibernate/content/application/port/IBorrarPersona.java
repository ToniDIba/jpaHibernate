package com.example.jpaHibernate.content.application.port;

import com.example.jpaHibernate.Persona;

public interface IBorrarPersona {

    //Cumplimentar la clase ...ExceptionHandler
    public Persona borrarPersonaId(int id) throws Exception;
    public Persona borrarPersona(String name) throws Exception;

}
