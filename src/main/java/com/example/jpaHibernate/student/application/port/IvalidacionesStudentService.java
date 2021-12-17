package com.example.jpaHibernate.student.application.port;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;

import java.util.ArrayList;

/**
 *  Comprueba que ciertos campos no vengan con "null", que tengan una longitud mínima y máxima...
 */

public interface IvalidacionesStudentService
{
    public String validarInfoStudent(Student student);

    String retornarIdOrName(String idOrName);

   ArrayList<StudentAsignature> extraerAsignaturaLista(ArrayList<StudentAsignature> miArray);
}







