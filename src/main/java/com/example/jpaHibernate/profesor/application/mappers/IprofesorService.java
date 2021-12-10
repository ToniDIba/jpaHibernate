package com.example.jpaHibernate.profesor.application.mappers;

import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.domain.Student;

public interface IprofesorService {

    DtoProfesorStudent convertirDtoPs (Profesor profesor, Student student);
}
