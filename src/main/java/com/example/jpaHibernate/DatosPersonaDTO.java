package com.example.jpaHibernate;

public class DatosPersonaDTO {


    public int id_persona;

    public int getId_persona() {
        return id_persona;
    }

    public void setId_persona(int id_persona) {
        this.id_persona = id_persona;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
