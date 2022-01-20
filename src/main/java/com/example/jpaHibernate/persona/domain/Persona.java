package com.example.jpaHibernate.persona.domain;

import com.example.jpaHibernate.student.domain.Student;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="Persona")
@Data
public class Persona {

    @GeneratedValue
    @Id
    public int id_personpers;

    public String usuario;
    public String password;

    public String name;

    public String surname;
    public String company_email;
    public String personal_email;
    public String city;

    public boolean admin;
    public boolean active;

    public Date created_date;
    public String imagen_url;
    public Date termination_date;



    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "id_personstd")
    Student student;

}


