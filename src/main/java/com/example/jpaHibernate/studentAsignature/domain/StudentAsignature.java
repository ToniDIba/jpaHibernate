package com.example.jpaHibernate.studentAsignature.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class StudentAsignature {


    @GeneratedValue
    @Id
    public String id_asignatura; // key autoIncremento
    public String id_student; // Estudiante con n asignaturas
    String asignatura; // html, spring...
    String comments;
    Date initial_date;
    Date finish_date;
    String branch;      //not null (Front / Back / Full)


}