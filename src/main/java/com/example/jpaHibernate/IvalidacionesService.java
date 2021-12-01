package com.example.jpaHibernate;

import java.util.Date;
import java.util.Optional;

/**
 *  Comprueba que ciertos campos no vengan con "null", que tengan una longitud mínima y máxima...
 */

public interface IvalidacionesService
{
    public String validarInfoPersona(Persona pers);
}







