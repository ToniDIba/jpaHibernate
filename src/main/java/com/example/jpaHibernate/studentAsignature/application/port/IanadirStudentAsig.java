package com.example.jpaHibernate.studentAsignature.application.port;

import com.example.jpaHibernate.exception.BadValidationToni;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;

public interface IanadirStudentAsig {

  void anyadirStudentAsignature(StudentAsignature studentAsignature) throws BadValidationToni;

}
