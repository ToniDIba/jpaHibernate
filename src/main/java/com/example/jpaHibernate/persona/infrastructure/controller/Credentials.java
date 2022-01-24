package com.example.jpaHibernate.persona.infrastructure.controller;


import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope("singleton")
public class Credentials {


    public boolean usuarioValido;
    public boolean esAdmin;


    public Credentials() { }


    public Credentials(boolean esAdmin, boolean usuarioValido)
    {
        this.esAdmin = false;
        this.usuarioValido = false;
    }




}
