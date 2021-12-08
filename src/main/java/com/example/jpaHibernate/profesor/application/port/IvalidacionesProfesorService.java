package com.example.jpaHibernate.profesor.application.port;

import com.example.jpaHibernate.profesor.domain.Profesor;

/**
 *  Comprueba que ciertos campos no vengan con "null", que tengan una longitud mínima y máxima...
 */

public interface IvalidacionesProfesorService
{
    public String validarInfoProfesor(Profesor profesor);

    //public Persona mapearInputOutput(InputDto inputDto);

    //String retornarIdOrName(String idOrName);
}







