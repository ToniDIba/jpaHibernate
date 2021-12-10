package com.example.jpaHibernate.studentAsignature.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.application.port.IBuscarStudentAsig;
import com.example.jpaHibernate.studentAsignature.application.port.IvalidacionesStudentAsigService;
import com.example.jpaHibernate.studentAsignature.domain.IstudentAsignatureRepositorio;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsultaStudentAsigController {


    @Autowired
    IvalidacionesStudentAsigService validacionesStudentAsigService;

    @Autowired
    IBuscarStudentAsig buscarStudentAsig;


    @GetMapping("/studentAsig/id/{idAsignatura}")
    public StudentAsignature consultaPorNombreOrId(@PathVariable String idAsignatura) throws Exception {

        StudentAsignature studentAsignatureBuscado = null;
        studentAsignatureBuscado = buscarStudentAsig.buscarStudentAsignatureId(idAsignatura);
        return studentAsignatureBuscado;

    }

}
