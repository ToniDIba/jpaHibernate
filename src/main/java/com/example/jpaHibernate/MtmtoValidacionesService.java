package com.example.jpaHibernate;

import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

@Service
public class MtmtoValidacionesService implements IvalidacionesService {


    @Override
    public String validarInfoPersona(Persona pers) {

        System.out.println("id_persona : " + pers.getId_persona());
        System.out.println("city : " + pers.getCity());
        System.out.println("company_email: " + pers.getCompany_email());
        System.out.println("created_date: " + pers.getCreated_date());
        System.out.println("imagen_url: " + pers.getImagen_url());
        System.out.println("name : " + pers.getName());
        System.out.println("password : " + pers.getPassword());
        System.out.println("personal_email: " + pers.getPersonal_email());
        System.out.println("surname : " + pers.getSurname());
        System.out.println("termination:date: " + pers.getTermination_date());
        System.out.println("usuario: " + pers.getUsuario());

        if(pers.getName() == null || pers.getName().length() == 0 ) return "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Name es null";

        if(pers.getUsuario() == null || pers.getUsuario().length() == 0 ) return "<<<<<<<<<<<<<<<<<<<<<<<<<<< Usuario es null";
        if(pers.getUsuario().length() < 6) return  " <<<<<<<<<<<<<<<<<<<<<<<<<<<<< usuario < 6";
        if(pers.getUsuario().length() > 10) return  "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< usuario > 10";

        if(pers.getPassword() == null || pers.getPassword().length() == 0) return "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Password es null";
        if(pers.getPersonal_email() == null || pers.getPersonal_email().length() == 0 ) return "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Personal mail es null";
        if(pers.getCompany_email() == null || pers.getCompany_email().length() == 0 ) return "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Company mail es null";
        if(pers.getCity() == null || pers.getCity().length() == 0) return "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< City es null";


        if(pers.getCreated_date() == null) return "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Name es null";

        return "ok";
    }
}
