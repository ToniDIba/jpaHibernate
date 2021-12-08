package com.example.jpaHibernate.profesor.application.port;

import com.example.jpaHibernate.exception.BadValidationToni;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.domain.Student;

public interface IanadirProfesor {

  void anyadirProfesor(Profesor profesor) throws BadValidationToni;

}
