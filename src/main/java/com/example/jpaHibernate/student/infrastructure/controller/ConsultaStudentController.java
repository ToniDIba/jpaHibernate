package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.profesor.application.mappers.DtoStudentProfesor;
import com.example.jpaHibernate.student.application.mappers.IStudentService;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsultaStudentController {


    @Autowired
    IBuscarStudent buscarStudent;

    @Autowired
    IStudentService studentService;


    @GetMapping("/student/id/{idStudent}")
    public DtoStudentProfesor consultaPorId(@PathVariable String idStudent) throws Exception
    {

        System.out.println("Entro buscar student");
        Student studentBuscado = buscarStudent.buscarStudentId(idStudent); //Busca por id numérico
        Profesor profesor = studentBuscado.getProfesor();

        DtoStudentProfesor miDto = studentService.convertirDtoSp(profesor, studentBuscado);
        //studentBuscado

        return miDto;
    }



}




