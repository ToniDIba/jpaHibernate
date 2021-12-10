package com.example.jpaHibernate.persona.infrastructure.controller.dto.output;

import lombok.Data;

@Data
public class DatosPersonaDTO {


    public int id_persona;
    public String usuario;
    public String password;
    public String name;


    //public DatosPersonaDTO(String usuario, String password, String name) {
    public DatosPersonaDTO(String name) {
        super();
        //this.usuario = usuario;
        this.password = password;
        this.name = name;
    }


}
