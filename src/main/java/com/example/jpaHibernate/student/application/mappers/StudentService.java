package com.example.jpaHibernate.student.application.mappers;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.application.mappers.DtoStudentProfesor;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.stereotype.Service;

@Service
public class StudentService implements IStudentService {


    @Override
    public DtoStudentProfesor convertirDtoSp(Profesor pf, Student st) {

        DtoStudentProfesor salidaDtoSp = new DtoStudentProfesor();

        salidaDtoSp.setPf_id_persona(pf.getId_personprof());
        salidaDtoSp.setPf_id_profesor(pf.getId_profesor());
        salidaDtoSp.setSt_id_persona(st.getId_personstd());
        salidaDtoSp.setSt_id_student(st.getId_student());
        salidaDtoSp.setPf_asignatura(pf.getAsignatura());
        salidaDtoSp.setPf_comments(pf.getComments());
        salidaDtoSp.setSt_id_profesor(st.getId_profesor());
        salidaDtoSp.setSt_num_hours_week(st.getNum_hours_week());
        salidaDtoSp.setSt_comments(st.getComments());
        salidaDtoSp.setSt_branch(st.getBranch());
        salidaDtoSp.setListaAsignaturas(st.getStudentasignaturas());

        return salidaDtoSp;
    }

    @Override
    public DtoRetorno crearDtoSimple(Student st) {

        DtoRetorno salidaDtoSimple = new DtoRetorno();

        salidaDtoSimple.setSt_branch(st.getBranch());
        salidaDtoSimple.setSt_comments(st.getComments());
        salidaDtoSimple.setSt_num_hours_week(st.getNum_hours_week());
        salidaDtoSimple.setSt_id_profesor(st.getId_profesor());
        salidaDtoSimple.setSt_id_student(st.getId_student());
        salidaDtoSimple.setSt_id_persona(st.getId_personstd());

        return salidaDtoSimple;
    }



    @Override
    public DtoRetorno crearDtoFull(Student st, Persona pers) {

        DtoRetorno salidaDtoFull = new DtoRetorno();

        salidaDtoFull.setSt_branch(st.getBranch());
        salidaDtoFull.setSt_comments(st.getComments());
        salidaDtoFull.setSt_num_hours_week(st.getNum_hours_week());
        salidaDtoFull.setSt_id_profesor(st.getId_profesor());
        salidaDtoFull.setSt_id_student(st.getId_student());
        salidaDtoFull.setSt_id_persona(st.getId_personstd());

        salidaDtoFull.setPers_usuario(pers.getUsuario());
        salidaDtoFull.setPers_password(pers.getPassword());
        salidaDtoFull.setPers_name(pers.getName());
        salidaDtoFull.setPers_surname(pers.getSurname());
        salidaDtoFull.setPers_company_email(pers.getCompany_email());
        salidaDtoFull.setPers_personal_email(pers.getCompany_email());
        salidaDtoFull.setPers_city(pers.getCity());
        salidaDtoFull.setPers_created_date(pers.getCreated_date());
        salidaDtoFull.setPers_imagen_url(pers.getImagen_url());
        salidaDtoFull.setPers_termination_date(pers.getTermination_date());

        return salidaDtoFull;
    }


}
