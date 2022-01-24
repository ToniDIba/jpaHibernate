package com.example.jpaHibernate.persona.application.port;

import com.example.jpaHibernate.persona.domain.Parametros;
import com.example.jpaHibernate.persona.infrastructure.controller.Credentials;
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

    void comprobarName(String name, Parametros params);

    boolean validarPasswordYUsuario(String user, String password, Credentials cr);

    String getJWTToken(String username);

}







