package com.example.jpaHibernate.profesor.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Profesor {

    @GeneratedValue
    @Id
    public String id_profesor; // key autoIncremento
    public String id_persona; //One to one con tabla Persona
    String comments;
    String branch;      //not null ( imparte Front / Back / Full)

}

