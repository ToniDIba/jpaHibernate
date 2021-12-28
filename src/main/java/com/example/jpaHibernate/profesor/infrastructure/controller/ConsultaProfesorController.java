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
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @RequestMapping(value = {"/profesor/id/{idProfesor}",
            "/profesor/id/{idProfesor}?{infoAdicional}"}, method = RequestMethod.GET)

      //public DtoProfesorStudent consultaPorId(Parametros parametros) throws Exception {
        public  ResponseEntity<DtoProfesorStudent> consultaPorId(Parametros parametros) throws Exception {

        //System.out.println("InfoAdicional: " + parametros.getInfoAdicional());
        System.out.println("IdProfesorPROVAl  : " + parametros.idProfesor);
        DtoProfesorStudent miDto = new DtoProfesorStudent();

        Profesor profesorBuscado = buscarProfesor.buscarProfesorId(parametros.idProfesor);
        List<Student> miLista = profesorBuscado.getStudent();

        int id_persona = profesorBuscado.getId_personprof();
        Persona miPersona = buscarPersona.buscarPersonaId(id_persona);

        if (parametros.getInfoAdicional() != null && parametros.getInfoAdicional().toUpperCase().equals("S"))
        {
            miDto = profesorService.convertirDtoPs(profesorBuscado, miLista, miPersona);
        } else{
            miDto = profesorService.convertirDtoPs(profesorBuscado, miLista);
        }

        //return miDto;
        System.out.println("Hago return REsponseEntity");
        return ResponseEntity.status(HttpStatus.OK).body(miDto);

    }

}
