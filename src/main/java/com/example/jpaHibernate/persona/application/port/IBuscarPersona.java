package com.example.jpaHibernate.persona.application.port;

import com.example.jpaHibernate.persona.domain.Persona;

public interface IBuscarPersona {

    //Cumplimentar la clase ...ExceptionHandler
    public Persona buscarPersonaId(int id) throws Exception;
    public Persona buscarPersona(String name) throws Exception;;

}
