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

    public String getId_student() {
        return id_student;
    }

    public void setId_student(String id_student) {
        this.id_student = id_student;
    }

    public String getId_persona() {
        return id_persona;
    }

    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }

    public int getNum_hours_week() {
        return num_hours_week;
    }

    public void setNum_hours_week(int num_hours_week) {
        this.num_hours_week = num_hours_week;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public int getId_profesor() {
        return id_profesor;
    }

    public void setId_profesor(int id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    int num_hours_week;
    String comments;
    int id_profesor;    //un solo profesor por estudiante
    String branch;      //not null (Front / Back / Full)


}
