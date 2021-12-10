package com.example.jpaHibernate.profesor.infrastructure.controller.repository;

import com.example.jpaHibernate.exception.NotFoundExceptionToni;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.application.port.IBuscarProfesor;
import com.example.jpaHibernate.profesor.domain.IprofesorRepositorio;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.domain.IstudentRepositorio;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Service
public class BuscarProfesorImplRepository implements IBuscarProfesor {


    @Autowired
    IprofesorRepositorio profesorRepositorio;


    Profesor profesor = new Profesor();
    //Persona personaBuscada = new Persona();



    @Override
    public Profesor buscarProfesorId(String id_profesor) throws Exception
    {
        profesor = profesorRepositorio.findById(id_profesor).orElseThrow(() -> new NotFoundExceptionToni("Profesor. No encuentro id: " + id_profesor));
        return profesor;
    }



    // Profesor no se busca por "name" - borrar más adelante------------------------------------------------------
    /* @Override
    public Profesor buscarProfesor(String nombreBuscado)  //Busca por nombre
    {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
        EntityManager em = emf.createEntityManager();
        TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.name = '" + nombreBuscado + "'", Persona.class);

        Persona personaBuscada = null;
        Student student = null;

        // buscaPorNombre no funciona. Ver IpersonaRepositorio

        try {
            personaBuscada = query.getSingleResult();

        } catch (NoResultException nre) {
            throw new NotFoundExceptionToni("No encuentro este nombre: " + nombreBuscado);
        }

        return profesor;
    } */


}



