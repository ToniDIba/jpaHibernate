package com.example.jpaHibernate.profesor.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.profesor.application.port.IBuscarProfesor;
import com.example.jpaHibernate.profesor.application.port.IvalidacionesProfesorService;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsultaProfesorController {


    @Autowired
    IBuscarProfesor buscarProfesor;


    @GetMapping("/profesor/id/{id}")
    public Profesor consultaPorId(@PathVariable String id) throws Exception {

        Profesor profesorBuscado = null;

        profesorBuscado = buscarProfesor.buscarProfesorId(id);
        return profesorBuscado;
    }


    public static boolean isNumeric(String str) {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }


}
