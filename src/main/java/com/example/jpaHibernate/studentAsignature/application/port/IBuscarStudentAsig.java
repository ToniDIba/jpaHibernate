package com.example.jpaHibernate.studentAsignature.application.port;

import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;

public interface IBuscarStudentAsig {

    //Cumplimentar la clase ...ExceptionHandler
    public StudentAsignature buscarStudentAsignatureId(String id_student) throws Exception;
    //public StudentAsignature buscarStudentAsignature(String name) throws Exception;;

}
