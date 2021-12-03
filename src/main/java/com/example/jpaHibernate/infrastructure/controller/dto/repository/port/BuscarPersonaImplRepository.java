package com.example.jpaHibernate.infrastructure.controller.dto.repository.port;

import com.example.jpaHibernate.Persona;

import com.example.jpaHibernate.config.exception.NotFoundExceptionToni;
import com.example.jpaHibernate.content.application.port.IBuscarPersona;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Service
public class BuscarPersonaImplRepository implements IBuscarPersona {


    @Autowired
    IpersonaRepositorio personaRepositorio;


    Persona pers = new Persona();


    @Override
    public Persona buscarPersonaId(String id) throws Exception  //Busca por número id
    {
        //pers = personaRepositorio.findById(Integer.parseInt(id)).get();
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
        Persona persBuscada = null;

        try {

            personaBuscada = query.getSingleResult();

            //Otra forma de hacer una query
            //List<DatosPersonaDTO> lista = em.createQuery("select distinct new com.example.jpaHibernate.infrastructure.controller.dto.output.DatosPersonaDTO(p.name) from Persona p", DatosPersonaDTO.class).getResultList();
            //System.out.println("Nombre" + lista.get(0).getName());

        } catch (NoResultException nre) {
            //persBuscada = new Persona();
            //String mensaje = " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   No existe persona con este nombre: " + nombreBuscado;
            //persBuscada.setSurname(mensaje);
            new NotFoundExceptionToni("No encuentro este nombre: " + nombreBuscado);
        }

        return personaBuscada;
    }


}



