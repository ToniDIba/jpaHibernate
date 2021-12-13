package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.application.mappers.DtoStudentProfesor;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.mappers.DtoRetorno;
import com.example.jpaHibernate.student.application.mappers.DtoSimple;
import com.example.jpaHibernate.student.application.mappers.IStudentService;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.student.infrastructure.controller.repository.Parametros;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
public class ConsultaStudentController {


    @Autowired
    IBuscarStudent buscarStudent;

    @Autowired
    IStudentService studentService;

    /*
      Si el Id es de un estudiante, retornamos un Dto con:
       - Datos del estudiante
       - ... de sus profesores
       - ... asignaturas que cursa
     */
    @RequestMapping(value = {"/student/previo/id/{idStudent}"}, method = RequestMethod.GET)
    public DtoStudentProfesor consultaPorId(Parametros parametros) throws Exception {

        Student studentBuscado = buscarStudent.buscarStudentId(parametros.getIdStudent());
        Profesor profesor = studentBuscado.getProfesor();

        DtoStudentProfesor miDto = studentService.convertirDtoSp(profesor, studentBuscado);
        return miDto;

    }

    /*
      Dependiendo de si han informado parámetro opcional "outputType", retorna un Dto con:
       - Datos del estudiante (si parámetro es "simple" o viene sin informar
       - Datos del estudiante y de la persona asociada (si el parámetro es "full")
     */

    @RequestMapping(value = {"/student/id/{idStudent}",
            "/student/id/{idStudent}?{infoAdicional}?{outputType}"}, method = RequestMethod.GET)
    public DtoRetorno escogerSimpleFull(Parametros parametros) throws Exception {

        System.out.println("InfoAdicional: " + parametros.getInfoAdicional());
        System.out.println("OutputType   : " + parametros.getOutputType());
        String outputType = (parametros.getOutputType() == null ||
                parametros.getOutputType().equals("simple")) ? "simple" : "full";

        Student studentBuscado = buscarStudent.buscarStudentId(parametros.getIdStudent()); //FetchById
        Persona persona = studentBuscado.getPersona();

        if (outputType.equals("simple")) {
            DtoRetorno miDtoretorno = simple(studentBuscado);
            return miDtoretorno;
        }

        if (outputType.equals("full")) {
            DtoRetorno miDtoretorno = full(studentBuscado, persona);
            return miDtoretorno;
        }






        return new DtoRetorno();
    }


    public DtoRetorno simple(Student studentBuscado) {  //Sólo datos del estudiante

        DtoRetorno dtoRetorno = studentService.crearDtoSimple(studentBuscado);
        return dtoRetorno;
    }


    public DtoRetorno full(Student studentBuscado, Persona persAsociada) { //Datos del estudiante y persona asociada

        DtoRetorno dtoRetorno = studentService.crearDtoFull(studentBuscado, persAsociada);
        return dtoRetorno;
    }


}