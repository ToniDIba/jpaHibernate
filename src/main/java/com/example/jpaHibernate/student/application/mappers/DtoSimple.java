package com.example.jpaHibernate.student.application.mappers;

import lombok.Data;

@Data
public class DtoSimple { //Sólo datos del estudiante

    public String st_id_student;
    public String st_id_persona;
    public String st_id_profesor;
    public int st_num_hours_week;
    public String st_comments;
    public String st_branch;

}
