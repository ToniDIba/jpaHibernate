package com.example.jpaHibernate.profesor.application.mappers;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import com.example.jpaHibernate.student.application.mappers.IStudentService;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class ProfesorService implements IprofesorService {

    @Override
    public DtoProfesorStudent convertirDtoPs(Profesor pf, List<Student> st) {

        DtoProfesorStudent salidaDtoPs = new DtoProfesorStudent();

        salidaDtoPs.setPf_id_profesor(pf.getId_profesor());
        salidaDtoPs.setPf_id_persona(pf.getId_personprof());
        salidaDtoPs.setPf_comments(pf.getComments());
        salidaDtoPs.setPf_asignatura(pf.getAsignatura());
        salidaDtoPs.setSt_studentList(st);

        return salidaDtoPs;

    }


    @Override
    public DtoProfesorStudent convertirDtoPs(Profesor pf, List<Student> st, Persona pers) {

        DtoProfesorStudent salidaDtoPs = new DtoProfesorStudent();

        salidaDtoPs.setPf_id_profesor(pf.getId_profesor());
        salidaDtoPs.setPf_id_persona(pf.getId_personprof());
        salidaDtoPs.setPf_comments(pf.getComments());
        salidaDtoPs.setPf_asignatura(pf.getAsignatura());

        salidaDtoPs.setSt_studentList(st);

        salidaDtoPs.setPers_id_persona(pers.getId_personpers());
        salidaDtoPs.setPers_usuario(pers.getUsuario());
        salidaDtoPs.setPers_password(pers.getPassword());
        salidaDtoPs.setPers_name(pers.getName());
        salidaDtoPs.setPers_surname(pers.getSurname());
        salidaDtoPs.setPers_company_email(pers.getCompany_email());
        salidaDtoPs.setPers_company_email(pers.getCompany_email());
        salidaDtoPs.setPers_city(pers.getCity());
        salidaDtoPs.setPers_active(pers.isActive());
        salidaDtoPs.setPers_created_date(pers.getCreated_date());
        salidaDtoPs.setPers_imagen_url(pers.getImagen_url());
        salidaDtoPs.setPers_termination_date(pers.termination_date);

        return salidaDtoPs;

    }


}

