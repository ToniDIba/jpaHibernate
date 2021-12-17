package com.example.jpaHibernate.student.infrastructure.controller;

// http://localhost:8085/addNuevasAsignaturas

import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.studentAsignature.domain.IstudentAsignatureRepositorio;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;


@RestController
public class AddNuevasAsignaturas {

    @Autowired
    IstudentAsignatureRepositorio studentAsignatureRepositorio;

    @Autowired
    IvalidacionesStudentService validacionesStudentService;


    /**
     *
     * Recibe una lista con un par de asignaturas para añadirlas a la tabla
     * @return las asignaturas a añadir
     */

    @RequestMapping(value = "/addNuevasAsignaturas", method = RequestMethod.POST)
    public ArrayList<StudentAsignature> anadirAsignaturas(@RequestBody ArrayList<StudentAsignature> jsonAsignaturas) {

        ArrayList<StudentAsignature> nuevasAsignaturas = validacionesStudentService.extraerAsignaturaLista(jsonAsignaturas);
        for (int i = 0; i < nuevasAsignaturas.size(); i++) {
            studentAsignatureRepositorio.save(nuevasAsignaturas.get(i));
        }

        return nuevasAsignaturas;
    }


}


/* ----------------- por ejemplo: ---------------------------------------
      [
         {
             "id_asignatura": "ASIG-020",
             "id_student": "STUD-001",
             "nombreAsignatura": "Csharp",
             "comments": "Curso de Csharp",
             "initial_date": "2022-01-06T00:00:00.000+00:00",
             "finish_date": "2022-06-30T00:00:00.000+00:00"
         },
         {
             "id_asignatura": "ASIG-021",
             "id_student": "STUD-001",
             "nombreAsignatura": "Python",
             "comments": "Curso de Python",
             "initial_date": "2022-01-06T00:00:00.000+00:00",
             "finish_date": "2022-06-30T00:00:00.000+00:00"
         }
     ]

 */
