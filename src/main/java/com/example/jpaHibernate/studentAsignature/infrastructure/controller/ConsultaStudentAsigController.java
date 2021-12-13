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

    IpersonaRepositorio personaRepositorio;


   // @GetMapping("/studentAsig/id/{idAsignatura}")
   // public StudentAsignature consultaPorNombreOrId(@PathVariable String idAsignatura) throws Exception {

    @RequestMapping(value = {"/studentAsig/id/{idAsignatura}",
                             "/studentAsig/id/{idAsignatura}?{infoAdicional}"}, method = RequestMethod.GET)
    public StudentAsignature consultaPorNombreOrId(Parametros parametros) throws Exception {



        if (parametros.getInfoAdicional() != null && parametros.getInfoAdicional().toUpperCase().equals("BORRAR=S"))
        {
            String estudianteDeLaAsignatura = buscarStudentAsig.buscarPersAsociada(parametros.idAsignatura); //STUD-001
            String  id_persona = buscarStudentAsig.buscarPersAsociada(estudianteDeLaAsignatura); //Idpersona=3
            Persona miPersona = buscarPersona.buscarPersonaId(id_persona); //busco persona 3
            personaRepositorio.delete(miPersona); //borro persona 3

            StudentAsignature sa = new StudentAsignature();
            sa.setComments("Persona borrada");
            return sa;
        }


        StudentAsignature studentAsignatureBuscado = null;
        studentAsignatureBuscado = buscarStudentAsig.buscarStudentAsignatureId(parametros.getIdAsignatura());
        return studentAsignatureBuscado;

    }

}
