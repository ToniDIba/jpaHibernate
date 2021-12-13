package com.example.jpaHibernate.profesor.application.mappers;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.domain.Student;

import java.util.List;

public interface IprofesorService {

    DtoProfesorStudent convertirDtoPs (Profesor profesor, List<Student> st);
    DtoProfesorStudent convertirDtoPs (Profesor profesor, List<Student> st, Persona pers);
}
