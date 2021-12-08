package com.example.jpaHibernate.profesor.infrastructure.controller.repository;

import com.example.jpaHibernate.profesor.application.port.IanadirProfesor;
import com.example.jpaHibernate.profesor.application.port.IvalidacionesProfesorService;
import com.example.jpaHibernate.profesor.domain.IprofesorRepositorio;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.port.IanadirStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.IstudentRepositorio;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AnadirProfesorImplRepository implements IanadirProfesor
{
    @Autowired
    IvalidacionesProfesorService validacionesProfesorService;

    @Autowired
    IprofesorRepositorio profesorRepositorio;


    @Override
    public void anyadirProfesor(Profesor profesor) {

        validacionesProfesorService.validarInfoProfesor(profesor);
        profesorRepositorio.save(profesor);

    }


}
