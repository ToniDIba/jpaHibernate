package com.example.jpaHibernate.persona.domain;

import lombok.Data;

import java.util.Date;


@Data
public class Parametros {

    public String user;
    public String name;
    public String surname;

    public String fechahigh;
    public String fechalow;

    public String ordenarpor;
    public int primerRegARecuperar;



}


