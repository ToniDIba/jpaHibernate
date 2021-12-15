package com.example.jpaHibernate.profesor.domain;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "profesor")
@Data
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

    @OneToMany()
    @JsonIgnore
    @JoinColumn(name = "id_profesor")
    private List<Student> student;

    public int id_personprof; //One to one con tabla Persona
    public String comments;
    public String asignatura;

}

