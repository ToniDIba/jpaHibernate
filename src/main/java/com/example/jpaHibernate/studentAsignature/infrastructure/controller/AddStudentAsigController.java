package com.example.jpaHibernate.studentAsignature.infrastructure.controller;

import com.example.jpaHibernate.exception.BadValidationToni;
import com.example.jpaHibernate.student.application.port.IanadirStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.application.port.IanadirStudentAsig;
import com.example.jpaHibernate.studentAsignature.application.port.IvalidacionesStudentAsigService;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddStudentAsigController {

    @Autowired
    IvalidacionesStudentAsigService validacionesStudentAsigService;

    @Autowired
    IanadirStudentAsig anadirStudentAsig;


    @PostMapping("/addStudentAsig")
    public StudentAsignature anadirStudentAsig(@RequestBody StudentAsignature inputStudentAsigDto) {

        String result  = validacionesStudentAsigService.validarInfoStudentAsignature(inputStudentAsigDto);
        if(!result.equals("Ok")) throw new BadValidationToni("Error en validación info Student asignatura: " + result);

        anadirStudentAsig.anyadirStudentAsignature(inputStudentAsigDto); //Hace un Repository.add
        return inputStudentAsigDto;
    }


}

