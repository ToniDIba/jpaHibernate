package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.student.application.port.IvalidacionesStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class ValidacionesServiceImpl implements IvalidacionesStudentService {


    @Override
    //public void validarInfoPersona(InputDto inputDto) {
    public void validarInfoStudent(Student student) {

        String resu = "ok";

        System.out.println("id_persona : " + student.getId_persona());
        System.out.println("id_student: " + student.getId_student());
        System.out.println("id_profe: " + student.getId_profesor());
        System.out.println("horas: " + student.getNum_hours_week());
        System.out.println("comments: " + student.getComments());
        System.out.println("initial branch : " + student.getBranch());


       /*if (student.getName() == null || student.getName().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Name es null";

        if (student.getUsuario() == null || student.getUsuario().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<< Usuario es null";

        if (student.getUsuario().length() < 6)
            resu = " <<<<<<<<<<<<<<<<<<<<<<<<<<<<< usuario < 6";

        if (student.getUsuario().length() > 10)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< usuario > 10";

        if (student.getPassword() == null || student.getPassword().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Password es null";

        if (student.getPersonal_email() == null || student.getPersonal_email().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Personal mail es null";

        if (student.getCompany_email() == null || student.getCompany_email().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Company mail es null";

        if (student.getCity() == null || student.getCity().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< City es null";

        if (student.getCreated_date() == null)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Name es null";

        if (!resu.equals("ok")) {
            NullPointerException nullPointer = new NullPointerException("Error controlado");
            throw nullPointer;
        }*/

        // return new Persona();
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