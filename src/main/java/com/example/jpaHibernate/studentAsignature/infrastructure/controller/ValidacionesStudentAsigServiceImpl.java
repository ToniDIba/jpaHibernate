package com.example.jpaHibernate.studentAsignature.infrastructure.controller;

import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.application.port.IvalidacionesStudentAsigService;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ValidacionesStudentAsigServiceImpl implements IvalidacionesStudentAsigService {


    @Override
    public String validarInfoStudentAsignature(StudentAsignature studentAsignature) {

        String resu = "Ok";

        System.out.println("id_asignatura : " + studentAsignature.getId_asignatura());
        System.out.println("id_student: " + studentAsignature.getId_student());
        System.out.println("Nombre asignatura: " + studentAsignature.getNombreAsignatura());
        System.out.println("Comentarios: " + studentAsignature.getComments());
        System.out.println("fecha inicio: " + studentAsignature.getInitial_date());
        System.out.println("fecha final : " + studentAsignature.getFinish_date() );


        if (studentAsignature.getComments().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Falta comentario";

        if (studentAsignature.getNombreAsignatura()  == "")
            resu = "<<<<<<<<<<<<<<<<<<<<< Nombre asignatura vacío";


         return resu;
    }

}