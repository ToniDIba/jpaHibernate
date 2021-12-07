package com.example.jpaHibernate.student.application.port;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.student.domain.Student;

/**
 *  Comprueba que ciertos campos no vengan con "null", que tengan una longitud mínima y máxima...
 */

public interface IvalidacionesStudentService
{
    public void validarInfoStudent(Student student);

    //public Persona mapearInputOutput(InputDto inputDto);

    String retornarIdOrName(String idOrName);
}







