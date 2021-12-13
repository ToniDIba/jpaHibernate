package com.example.jpaHibernate.student.application.mappers;

import lombok.Data;

import java.util.Date;

@Data
public class DtoRetorno { //datos del estudiante y persona asociada

    public String st_id_student;
    public String st_id_persona;
    public String st_id_profesor;
    public int st_num_hours_week;
    public String st_comments;
    public String st_branch;

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
