package com.example.jpaHibernate.student.application.mappers;

import com.example.jpaHibernate.student.domain.Student;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class DtoProfesorStudent {

    public String pf_id_profesor;
    public String pf_id_persona;
    public String pf_comments;
    public String pf_asignatura;

    public List<Student> st_studentList;

    public int pers_id_persona;
    public String pers_usuario;
    public String pers_password;
    public String pers_name;
    public String pers_surname;
    public String pers_company_email;
    public String pers_personal_email;
    public String pers_city;
    public boolean pers_active;
    public Date pers_created_date;
    public String pers_imagen_url;
    public Date pers_termination_date;


}
