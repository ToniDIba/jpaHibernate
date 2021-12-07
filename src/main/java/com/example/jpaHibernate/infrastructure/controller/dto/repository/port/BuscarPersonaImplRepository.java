package com.example.jpaHibernate.infrastructure.controller.dto.repository.port;

import com.example.jpaHibernate.Persona;

import com.example.jpaHibernate.config.exception.NotFoundExceptionToni;
import com.example.jpaHibernate.content.application.port.IBuscarPersona;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import javax.persistence.*;
import java.util.List;


@Service
public class BuscarPersonaImplRepository implements IBuscarPersona {


    @Autowired
    IpersonaRepositorio personaRepositorio;


    Persona pers = new Persona();



    @Override
    public Persona buscarPersonaId(String id) throws Exception  //Busca por número id
    {
        pers = personaRepositorio.findById(Integer.parseInt(id)).orElseThrow(() -> new NotFoundExceptionToni("No encuentro id: " + id));
        return pers;
    }



    @Override
    public Persona buscarPersona(String nombreBuscado)  //Busca por nombre
    {



        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.name = '" + nombreBuscado + "'", Persona.class);

        Persona personaBuscada = null;

        // buscaPorNombre no funciona. Ver IpersonaRepositorio

        try {
            personaBuscada = query.getSingleResult();

        } catch (NoResultException nre) {
            throw new NotFoundExceptionToni("No encuentro este nombre: " + nombreBuscado);
        }

        return personaBuscada;
    }


}



