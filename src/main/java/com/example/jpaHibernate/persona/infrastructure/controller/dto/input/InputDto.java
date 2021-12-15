package com.example.jpaHibernate.persona.infrastructure.controller.dto.input;
import lombok.Data;

import java.util.Date;

@Data
public class InputDto {

        public int id_personapers;
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
