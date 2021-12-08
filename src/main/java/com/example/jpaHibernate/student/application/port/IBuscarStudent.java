package com.example.jpaHibernate.student.application.port;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.student.domain.Student;

public interface IBuscarStudent {

    //Cumplimentar la clase ...ExceptionHandler
    public Student buscarStudentId(String id_student) throws Exception;
    public Student buscarStudent(String name) throws Exception;;

}
