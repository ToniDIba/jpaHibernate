package com.example.jpaHibernate.profesor.infrastructure.controller;


import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.application.mappers.DtoStudentProfesor;
import com.example.jpaHibernate.profesor.application.mappers.IprofesorService;
import com.example.jpaHibernate.profesor.application.port.IBuscarProfesor;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.profesor.infrastructure.controller.repository.ParamId;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.application.mappers.DtoRetorno;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.student.infrastructure.controller.repository.BuscarStudentImplRepository;
import com.example.jpaHibernate.student.infrastructure.controller.repository.Parametros;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class ConsultaProfesorController {

    @Autowired
    IBuscarProfesor buscarProfesor;

    @Autowired
    IBuscarPersona buscarPersona;

    @Autowired
    IprofesorService profesorService;

    @Autowired
    BuscarStudentImplRepository buscarStudentImplRepository;


    //@GetMapping("/profesor/id/{idProfesor}")
    //public DtoProfesorStudent consultaPorId(@PathVariable("idProfesor") String idProfesor) throws Exception
    // {


    // http://localhost:8085/profesor/id/PROF-001

    //@RequestMapping(value = {"/profesor/id/{idProfesor}"}, method = RequestMethod.GET)
    @RequestMapping(value = {"/profesor/id/{idProfesor}",
            "/profesor/id/{idProfesor}?{infoAdicional}"}, method = RequestMethod.GET)

    public DtoProfesorStudent consultaPorId(Parametros parametros) throws Exception {

        DtoProfesorStudent miDto = new DtoProfesorStudent();

        System.out.println("InfoAdicional: " + parametros.getInfoAdicional());
        System.out.println("IdProfesor   : " + parametros.idProfesor);

        System.out.println("entra " + parametros.idProfesor);

        Profesor profesorBuscado = buscarProfesor.buscarProfesorId(parametros.idProfesor);
        //Student student = profesorBuscado.getStudent();
        List<Student> miLista = profesorBuscado.getStudent();

        int id_persona = profesorBuscado.getId_personprof();
        Persona miPersona = buscarPersona.buscarPersonaId(id_persona);
        // List<StudentAsignature> listAsignaturas = miLista.getStudentasignaturas();

        if (parametros.getInfoAdicional() != null && parametros.getInfoAdicional().toUpperCase().equals("S"))
        {
            miDto = profesorService.convertirDtoPs(profesorBuscado, miLista, miPersona);
        } else{
            miDto = profesorService.convertirDtoPs(profesorBuscado, miLista);
        }

        return miDto;


    }


}


//@RequestMapping(value = {"/student/previo/id/{idStudent}"}, method = RequestMethod.GET)