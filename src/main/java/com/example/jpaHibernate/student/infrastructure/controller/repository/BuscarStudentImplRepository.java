package com.example.jpaHibernate.student.infrastructure.controller.repository;

import com.example.jpaHibernate.exception.NotFoundExceptionToni;
import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.profesor.domain.IprofesorRepositorio;
import com.example.jpaHibernate.profesor.domain.Profesor;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.domain.IstudentRepositorio;
import com.example.jpaHibernate.student.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Service
public class BuscarStudentImplRepository implements IBuscarStudent {


    @Autowired
    IstudentRepositorio studentRepositorio;

    @Autowired
    IprofesorRepositorio profesorRepositorio;


    Student student = new Student();
    Profesor profesor = new Profesor();


    Persona personaBuscada = new Persona();



    @Override
    public Student buscarStudentId(String id_student) throws Exception  //Busca por número id
    {
        student = studentRepositorio.findById(id_student).orElseThrow(() -> new NotFoundExceptionToni("Student. No encuentro id: " + id_student));
        return student;
    }



    @Override
    public Student buscarStudent(String nombreBuscado)  //Busca por nombre
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

        return student;
    }


}



