package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsultaStudentController {


    @Autowired
    IpersonaRepositorio personaRepositorio;

    @Autowired
    IvalidacionesStudentService validacionesStudentService;

    @Autowired
    IBuscarStudent buscarStudent;



    @GetMapping("/student/id/{idOrName}")
    public Student consultaPorNombreOrId(@PathVariable String idOrName) throws Exception
    {

        Student studentBuscado = null;
        String claveBusqueda = validacionesStudentService.retornarIdOrName(idOrName);


        if(isNumeric(claveBusqueda)) {
             studentBuscado = buscarStudent.buscarStudentId(claveBusqueda); //Busca por id numérico
        }
        else {
            studentBuscado = buscarStudent.buscarStudent(claveBusqueda);  //Busca por nombre persona
        }


        return studentBuscado;

    }

    public static boolean isNumeric(String str)
    {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }



}
