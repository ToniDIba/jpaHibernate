package com.example.jpaHibernate.profesor.domain;

import com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Profesor {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "id_profesor")
    @GenericGenerator(
            name = "id_profesor",
            strategy = "com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator",
            parameters = {
                    @Parameter(name = StringPrefixedSequenceIdGenerator.INCREMENT_PARAM, value = "1"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.VALUE_PREFIX_PARAMETER, value = "PROF-"),
                    @Parameter(name = StringPrefixedSequenceIdGenerator.NUMBER_FORMAT_PARAMETER, value = "%03d")
            })

    public String id_profesor;




    public String id_persona; //One to one con tabla Persona

    public String getId_profesor() {
        return id_profesor;
    }
    public void setId_profesor(String id_profesor) {
        this.id_profesor = id_profesor;
    }

    public String getId_persona() {
        return id_persona;
    }
    public void setId_persona(String id_persona) {
        this.id_persona = id_persona;
    }



}

