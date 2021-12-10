package com.example.jpaHibernate.persona.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Persona {

    @GeneratedValue
    @Id
    public int id_persona;

    public String usuario;
    public String password;
    public String name;
    public String surname;
    public String company_email;
    public String personal_email;
    public String city;
    public boolean active;
    public Date created_date;
    public String imagen_url;
    public Date termination_date;

}
