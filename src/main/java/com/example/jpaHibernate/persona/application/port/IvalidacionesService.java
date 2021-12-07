package com.example.jpaHibernate.persona.application.port;

import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.persona.domain.Persona;

/**
 *  Comprueba que ciertos campos no vengan con "null", que tengan una longitud mínima y máxima...
 */

public interface IvalidacionesService
{
    public void validarInfoPersona(Persona persona);

    public Persona mapearInputOutput(InputDto inputDto);

    String retornarIdOrName(String idOrName);
}






