package com.example.jpaHibernate.student.application.port;

import com.example.jpaHibernate.exception.BadValidationToni;
import com.example.jpaHibernate.student.domain.Student;

public interface IanadirStudent {

  void anyadirStudent(Student student) throws BadValidationToni;

}
