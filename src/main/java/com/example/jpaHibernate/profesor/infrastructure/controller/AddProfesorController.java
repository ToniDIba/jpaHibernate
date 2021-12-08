package com.example.jpaHibernate.profesor.infrastructure.controller;

import com.example.jpaHibernate.exception.BadValidationToni;
import com.example.jpaHibernate.profesor.application.port.IanadirProfesor;
import com.example.jpaHibernate.profesor.application.port.IvalidacionesProfesorService;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.port.IanadirStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddProfesorController {

    @Autowired
    IvalidacionesProfesorService validacionesProfesorService;

    @Autowired
    IanadirProfesor anadirProfesor;


    @PostMapping("/addProfesor")
    public Profesor anadirProfesor(@RequestBody Profesor inputProfesorDto) {

        String result  = validacionesProfesorService.validarInfoProfesor(inputProfesorDto);
        if(!result.equals("Ok")) throw new BadValidationToni("Error en validación info Profesor: " + result);

        anadirProfesor.anyadirProfesor(inputProfesorDto); //Hace un Repository.add
        return inputProfesorDto;
    }

}

