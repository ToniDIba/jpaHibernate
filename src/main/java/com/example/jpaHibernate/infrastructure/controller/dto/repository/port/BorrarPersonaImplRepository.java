package com.example.jpaHibernate.infrastructure.controller.dto.repository.port;

import com.example.jpaHibernate.Persona;
import com.example.jpaHibernate.config.exception.UnprocesableExceptionToni;
import com.example.jpaHibernate.content.application.port.IBorrarPersona;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Service
public class BorrarPersonaImplRepository implements IBorrarPersona {

    @Autowired
    IpersonaRepositorio personaRepositorio;


    Persona pers = new Persona();

    @Override
    public Persona borrarPersonaId(int id) throws Exception  // Borra por Id.
    {
        pers = personaRepositorio.findById(id).orElseThrow(() -> new UnprocesableExceptionToni("No existe esta persona para borrarla: " + id));
        personaRepositorio.delete(pers);
        return pers;
    }


    @Override
    public Persona borrarPersona(String nombreBuscado) throws Exception   //Borra por nombre
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.name = '" + nombreBuscado + "'", Persona.class);

        try {
            pers = query.getSingleResult();
        } catch (NoResultException nre) {
            throw new UnprocesableExceptionToni("No existe esta persona para borrarla: " + nombreBuscado);
        }

        personaRepositorio.delete(pers);
        return pers;

    }

}
