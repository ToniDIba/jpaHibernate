package com.example.jpaHibernate.studentAsignature.infrastructure.controller.repository;

import com.example.jpaHibernate.exception.BadValidationToni;
import com.example.jpaHibernate.student.application.port.IanadirStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.IstudentRepositorio;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.application.port.IanadirStudentAsig;
import com.example.jpaHibernate.studentAsignature.application.port.IvalidacionesStudentAsigService;
import com.example.jpaHibernate.studentAsignature.domain.IstudentAsignatureRepositorio;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AnadirStudentAssignatureImplRepository implements IanadirStudentAsig
{

    @Autowired
    IvalidacionesStudentAsigService validacionesStudentAsigService;

    @Autowired
    IstudentAsignatureRepositorio studentAsignatureRepositorio;


    @Override
    public void anyadirStudentAsignature(StudentAsignature studentAsignature) throws BadValidationToni {

        validacionesStudentAsigService.validarInfoStudentAsignature(studentAsignature);
        studentAsignatureRepositorio.save(studentAsignature);

    }
}
