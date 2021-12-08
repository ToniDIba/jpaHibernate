package com.example.jpaHibernate.student.domain;


import com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Properties;

@Entity
public class Student  {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_student")
    @GenericGenerator(
            name = "id_student",
            strategy = "com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "STUD-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })

    public String id_student;





    public String id_persona; //One to one con tabla Persona
    public int num_hours_week;
    public String comments;
    public String id_profesor;    //un solo profesor por estudiante
    public String branch;      //not null (Front / Back / Full)


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

    public String  getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getBranch() {
        return branch;
    }
    public void setBranch(String branch) {
        this.branch = branch;
    }

}
