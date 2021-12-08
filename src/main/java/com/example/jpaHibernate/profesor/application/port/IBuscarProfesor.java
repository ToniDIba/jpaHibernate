package com.example.jpaHibernate.profesor.application.port;

import com.example.jpaHibernate.profesor.domain.Profesor;

public interface IBuscarProfesor {

    //Cumplimentar la clase ...ExceptionHandler
    public Profesor buscarProfesorId(String id_profesor) throws Exception;

    //Borrar
    //public Profesor buscarProfesor(String name) throws Exception;;

}
