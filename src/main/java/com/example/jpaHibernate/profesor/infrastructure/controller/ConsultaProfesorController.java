package com.example.jpaHibernate.profesor.infrastructure.controller;

import com.example.jpaHibernate.profesor.application.mappers.IprofesorService;
import com.example.jpaHibernate.profesor.application.port.IBuscarProfesor;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsultaProfesorController {


    @Autowired
    IBuscarProfesor buscarProfesor;

    @Autowired
    IprofesorService profesorService;


    @GetMapping("/profesor/id/{id}")
    public DtoProfesorStudent consultaPorId(@PathVariable String idProfesor) throws Exception {

        System.out.println("entra");

        //Profesor profesorBuscado = null;
        //profesorBuscado = buscarProfesor.buscarProfesorId(id);
        //return profesorBuscado


        Profesor profesorBuscado = buscarProfesor.buscarProfesorId(idProfesor);
        Student student = profesorBuscado.getStudent();

        DtoProfesorStudent miDto = profesorService.convertirDtoPs(profesorBuscado, student);
        //studentBuscado

        return miDto;
    }

}
















