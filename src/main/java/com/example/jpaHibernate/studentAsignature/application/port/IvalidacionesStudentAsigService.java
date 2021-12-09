package com.example.jpaHibernate.studentAsignature.application.port;

import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;

/**
 *  Comprueba que ciertos campos no vengan con "null", que tengan una longitud mínima y máxima...
 */

public interface IvalidacionesStudentAsigService
{
    public String validarInfoStudentAsignature(StudentAsignature studentAsignature);

    //public Persona mapearInputOutput(InputDto inputDto);
   //String retornarIdOrName(String idOrName);
}







