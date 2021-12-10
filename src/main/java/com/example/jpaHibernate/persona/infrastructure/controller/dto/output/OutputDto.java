package com.example.jpaHibernate.persona.infrastructure.controller.dto.output;


import lombok.Data;

import java.util.Date;

@Data
public class OutputDto {

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
