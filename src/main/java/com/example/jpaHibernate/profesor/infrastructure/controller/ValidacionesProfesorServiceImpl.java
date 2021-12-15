package com.example.jpaHibernate.profesor.infrastructure.controller;

import com.example.jpaHibernate.profesor.application.port.IvalidacionesProfesorService;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ValidacionesProfesorServiceImpl implements IvalidacionesProfesorService {


    @Override
    public String validarInfoProfesor(Profesor profesor) {

        String resu = "Ok";

        System.out.println("id_persona : " + profesor.getId_personprof());
        System.out.println("id_profesor: " + profesor.getId_profesor());


        if (profesor.getId_profesor() == "")
            resu = "<<<<<<<<<<<<<<<<<<<<< Id Profesor es null";


         return resu;
    }


    /* ---------------------- profesor siempre se busca por Id. Borrar más adelante
    @Override
    public String retornarIdOrName(String idOrName) {

        Optional<Integer> idParam = Optional.empty();
        Optional<String> nombreParam;

        idOrName = idOrName.trim();
        String nombreBuscado = null;

        try {
            idParam = Optional.ofNullable(Integer.parseInt(idOrName));         // Busca por "Id";
        } catch (NumberFormatException nfe) {
            nombreParam = Optional.ofNullable(idOrName);
            nombreBuscado = nombreParam.get();                                //Busca por "Name"
        }

        if (idParam.isPresent()) {
            return idParam.get().toString();
        } else {
            return nombreBuscado;
        }

    }

     */
}