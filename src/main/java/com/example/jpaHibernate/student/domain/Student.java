package com.example.jpaHibernate.student.domain;


import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.infrastructure.controller.StringPrefixedSequenceIdGenerator;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.HibernateException;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.enhanced.SequenceStyleGenerator;
import org.hibernate.internal.util.config.ConfigurationHelper;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.LongType;
import org.hibernate.type.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Set;

@Entity
@Data
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


   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_persona", insertable = false, updatable = false)
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   Persona persona;


   @OneToOne(fetch = FetchType.EAGER)
   @JoinColumn(name = "id_profesor" , insertable = false, updatable = false)
   @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
   Profesor profesor;


    @OneToMany(cascade = CascadeType.ALL, mappedBy = "id_student")
    public List<StudentAsignature> Studentasignaturas;
    @ManyToOne
    @JoinColumn(name = "student_id_student")
    Student student;



    public String id_persona;     //One to one con tabla Persona
    public String id_profesor;    //un solo profesor por estudiante

    public int num_hours_week;
    public String comments;
    public String branch;      //not null (Front / Back / Full)



}
