package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ValidacionesStudentServiceImpl implements IvalidacionesStudentService {


    @Override
    public String validarInfoStudent(Student student) {

        String resu = "Ok";

        System.out.println("id_persona : " + student.getId_persona());
        System.out.println("id_student: " + student.getId_student());
        System.out.println("id_profe: " + student.getId_profesor());
        System.out.println("horas: " + student.getNum_hours_week());
        System.out.println("comments: " + student.getComments());
        System.out.println("initial branch : " + student.getBranch());


        if (student.getBranch () == null || student.getBranch().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Name es null";

        if (student.getId_profesor() == "")
            resu = "<<<<<<<<<<<<<<<<<<<<< Id Profesor es cero";

        //if (student.getId_student().length() < 3)
        //    resu = " <<<<<<<<<<<<<<<<<<<<<<<<<<<<< id usuario < 3";

        if (student.getNum_hours_week() < 10)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Horas semanales < 10";

         return resu;
    }



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
}