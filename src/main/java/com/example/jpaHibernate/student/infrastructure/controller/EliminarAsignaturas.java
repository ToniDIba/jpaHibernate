package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.studentAsignature.domain.IstudentAsignatureRepositorio;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;


/**
 *
 * Recibe una lista con las asignaturas para borrar de la tabla
 * @return las asignaturas a borrar
 */

@RestController
public class EliminarAsignaturas {

    @Autowired
    IstudentAsignatureRepositorio studentAsignatureRepositorio;


    @RequestMapping(value = "/eliminarNuevasAsignaturas", method = RequestMethod.POST)
    public ArrayList<StudentAsignature> eliminarAsignaturas(@RequestBody ArrayList<StudentAsignature> jsonAsignaturasBorrar) {

        for (int i = 0; i < jsonAsignaturasBorrar.size(); i++) {
            studentAsignatureRepositorio.delete(jsonAsignaturasBorrar.get(i));
        }

        return jsonAsignaturasBorrar;
    }

}
