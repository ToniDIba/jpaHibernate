package com.example.jpaHibernate.studentAsignature.infrastructure.controller;

import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.student.infrastructure.controller.repository.Parametros;
import com.example.jpaHibernate.studentAsignature.application.port.IBuscarStudentAsig;
import com.example.jpaHibernate.studentAsignature.application.port.IvalidacionesStudentAsigService;
import com.example.jpaHibernate.studentAsignature.domain.IstudentAsignatureRepositorio;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class ConsultaStudentAsigController {


    @Autowired
    IvalidacionesStudentAsigService validacionesStudentAsigService;

    @Autowired
    IBuscarStudentAsig buscarStudentAsig;

    @Autowired
    IBuscarPersona buscarPersona;

    @Autowired
    IpersonaRepositorio personaRepositorio;


   // @GetMapping("/studentAsig/id/{idAsignatura}")
   // public StudentAsignature consultaPorNombreOrId(@PathVariable String idAsignatura) throws Exception {

    @RequestMapping(value = {"/studentAsig/id/{idAsignatura}",
                             "/studentAsig/id/{idAsignatura}?{infoAdicional}"}, method = RequestMethod.GET)
    public StudentAsignature consultaPorNombreOrId(Parametros parametros) throws Exception {

     // http://localhost:8085/studentAsig/id/ASIG-001?infoAdicional=BORRARS

        if (parametros.getInfoAdicional() != null && parametros.getInfoAdicional().toUpperCase().equals("BORRARS"))
        {
            int estudianteDeLaAsignatura = buscarStudentAsig.buscarPersAsociada(parametros.idAsignatura); //STUD-001
            Persona miPersona = buscarPersona.buscarPersonaId(estudianteDeLaAsignatura); //busco persona 3

            personaRepositorio.delete(miPersona);

            StudentAsignature sa = new StudentAsignature();
            sa.setComments("Persona borrada");
            return sa;
        }


        StudentAsignature studentAsignatureBuscado = null;
        studentAsignatureBuscado = buscarStudentAsig.buscarStudentAsignatureId(parametros.getIdAsignatura());
        return studentAsignatureBuscado;

    }

}
