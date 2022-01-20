package com.example.jpaHibernate.persona.infrastructure.controller.dto.repository;

import com.example.jpaHibernate.persona.domain.Persona;

import com.example.jpaHibernate.exception.NotFoundExceptionToni;
import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Service
public class BuscarPersonaImplRepository implements IBuscarPersona {


    @Autowired
    IpersonaRepositorio personaRepositorio;


    Persona pers = new Persona();
    List<Persona> misPersonas = new ArrayList();



    @Override
    public Persona buscarPersonaId(int id) throws Exception  //Busca por número id
    {
        pers = personaRepositorio.findById(id).orElseThrow(() -> new NotFoundExceptionToni("No encuentro id: " + id));
        //pers = personaRepositorio.findById(3).orElseThrow(() -> new NotFoundExceptionToni("No encuentro id: " + id));
        return pers;
    }



    @Override
    public Persona buscarPersona(String nombreBuscado)  //Busca por nombre
    {

       /* EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.name = '" + nombreBuscado + "'", Persona.class);

        Persona personaBuscada = null;

        // buscaPorNombre no funciona. Ver IpersonaRepositorio

        try {
            personaBuscada = query.getSingleResult();

        } catch (NoResultException nre) {
            throw new NotFoundExceptionToni("No encuentro este nombre: " + nombreBuscado);
        } */

        //return personaBuscada; original era este
        return pers;
    }



    @Override
    public List<Persona> findPersonaByUsuario(String usuario) {
        misPersonas = personaRepositorio.findPersonaByUsuario(usuario);
        return  misPersonas;
    }


}



