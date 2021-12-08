package com.example.jpaHibernate.student.infrastructure.controller.repository;

import com.example.jpaHibernate.persona.application.port.IanadirPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.student.application.port.IanadirStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.IstudentRepositorio;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnadirStudentImplRepository implements IanadirStudent
{
    @Autowired
    IvalidacionesStudentService validacionesStudentService;

    @Autowired
    IstudentRepositorio studentRepositorio;


    @Override
    public void anyadirStudent(Student student) {

        validacionesStudentService.validarInfoStudent(student);
        studentRepositorio.save(student);

    }


}
