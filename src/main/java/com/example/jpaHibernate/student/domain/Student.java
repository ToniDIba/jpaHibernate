package com.example.jpaHibernate.student.domain;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Student {

    @GeneratedValue
    @Id
    public String id_student; // key autoIncremento
    public String id_persona; //One to one con tabla Persona
    int num_hours_week;
    String comments;
    int id_profesor;    //un solo profesor por estudiante
    String branch;      //not null (Front / Back / Full)


}
