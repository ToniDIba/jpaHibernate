package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.exception.BadValidationToni;
import com.example.jpaHibernate.persona.application.port.IanadirPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.student.application.port.IanadirStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class AddStudentController {

    @Autowired
    IvalidacionesStudentService validacionesStudentService;

    @Autowired
    IanadirStudent anadirStudent;


    @PostMapping("/addStudent")
    public Student anadirStudent(@RequestBody Student inputStudentDto) {

        String result  = validacionesStudentService.validarInfoStudent(inputStudentDto);
        if(!result.equals("Ok")) throw new BadValidationToni("Error en validación info Student: " + result);

        anadirStudent.anyadirStudent(inputStudentDto); //Hace un Repository.add
        return inputStudentDto;
    }





}

