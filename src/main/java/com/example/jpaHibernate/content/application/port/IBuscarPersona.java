package com.example.jpaHibernate.content.application.port;

import com.example.jpaHibernate.Persona;

public interface IBuscarPersona {

    //Cumplimentar la clase ...ExceptionHandler
    public Persona buscarPersonaId(String id) throws Exception;
    public Persona buscarPersona(String name) throws Exception;;

}
