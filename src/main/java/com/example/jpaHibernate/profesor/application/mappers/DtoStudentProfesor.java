package com.example.jpaHibernate.profesor.application.mappers;

import lombok.Data;

@Data
public class DtoStudentProfesor {

    public String pf_id_profesor;
    public String pf_id_persona;
    public String pf_comments;
    public String pf_asignatura;

    public String st_id_student;
    public String st_id_persona;
    public String st_id_profesor;
    public int st_num_hours_week;
    public String st_comments;
    public String st_branch;

}
