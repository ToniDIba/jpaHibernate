package com.example.jpaHibernate.content.application.port;

import com.example.jpaHibernate.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.Persona;

/**
 *  Comprueba que ciertos campos no vengan con "null", que tengan una longitud mínima y máxima...
 */

public interface IvalidacionesService
{
    public void validarInfoPersona(Persona persona);

    public Persona mapearInputOutput(InputDto inputDto);

}







