package com.example.jpaHibernate.profesor.infrastructure.controller;


import com.example.jpaHibernate.profesor.application.mappers.IprofesorService;
import com.example.jpaHibernate.profesor.application.port.IBuscarProfesor;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.profesor.infrastructure.controller.repository.ParamId;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.application.mappers.DtoRetorno;
import com.example.jpaHibernate.student.domain.Student;
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
    IprofesorService profesorService;




    //@GetMapping(value = "/profesor/id/{id_profesor}")

  //public DtoProfesorStudent consultaPorId(@PathVariable String idProfesor) throws Exception {
  //  public DtoProfesorStudent consultaPorId(ParamId paramId                ) throws Exception {


 /*   @RequestMapping(value = {"/student/id/{idStudent}",
            "/student/id/{idStudent}?{outputType}"}, method = RequestMethod.GET)
    public DtoRetorno escogerSimpleFull(Parametros parametros) throws Exception {

        String outputType = (parametros.getOutputType() == null || */



    @RequestMapping(value = "/profesor/id/{id_profesor}", method = RequestMethod.GET)
    public DtoProfesorStudent consultaPorId(ParamId paramId) throws Exception {

        System.out.println("entra " + paramId.getId_Profesor());

        Profesor profesorBuscado = buscarProfesor.buscarProfesorId(paramId.getId_Profesor());
        Student student = profesorBuscado.getStudent();
        List<StudentAsignature> listAsignaturas = student.getStudentasignaturas();

        DtoProfesorStudent miDto = profesorService.convertirDtoPs(profesorBuscado, student);

        return miDto;

    }


}

