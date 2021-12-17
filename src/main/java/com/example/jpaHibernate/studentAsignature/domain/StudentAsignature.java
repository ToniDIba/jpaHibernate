package com.example.jpaHibernate.studentAsignature.domain;

import com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;


@Entity
@Data
public class StudentAsignature  {

    public StudentAsignature() {  }

    public StudentAsignature( String id_asignatura,
            String id_student,
            String nombreAsignatura,
            String comments,
            Date initial_date,
            Date finish_date)
    {

        this.id_asignatura = id_asignatura;
        this.id_student = id_student;
        this.nombreAsignatura = nombreAsignatura;
        this.comments = comments;
        this.initial_date = initial_date;
        this.finish_date = finish_date;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_asignatura")
    @GenericGenerator(
            name = "id_asignatura",
            strategy = "com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "ASIG-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })

    public String id_asignatura; // Primarykey autoIncremento

    //@OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_persona", insertable = false, updatable = false)
    // Persona persona;


    // @OneToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "id_profesor" , insertable = false, updatable = false)
    // Profesor profesor;


    //@OneToMany(mappedBy = "id_student")
    // StudentAsignature studentAsignature;
    // private ArrayList<StudentAsignature> items = new ArrayList<StudentAsignature>();


    public String id_student;
    String nombreAsignatura;
    String comments;
    Date initial_date;
    Date finish_date;


}







