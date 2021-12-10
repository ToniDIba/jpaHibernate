package com.example.jpaHibernate.student.application.mappers;

import com.example.jpaHibernate.profesor.application.mappers.DtoStudentProfesor;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.domain.Student;

public interface IStudentService {


   DtoStudentProfesor convertirDtoSp (Profesor profesor, Student student);


}
