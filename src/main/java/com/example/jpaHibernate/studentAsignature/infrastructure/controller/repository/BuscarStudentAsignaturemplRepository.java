package com.example.jpaHibernate.studentAsignature.infrastructure.controller.repository;

import com.example.jpaHibernate.exception.NotFoundExceptionToni;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.student.application.port.IBuscarStudent;
import com.example.jpaHibernate.student.domain.IstudentRepositorio;
import com.example.jpaHibernate.student.domain.Student;
import com.example.jpaHibernate.studentAsignature.application.port.IBuscarStudentAsig;
import com.example.jpaHibernate.studentAsignature.domain.IstudentAsignatureRepositorio;
import com.example.jpaHibernate.studentAsignature.domain.StudentAsignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.*;


@Service
public class BuscarStudentAsignaturemplRepository implements IBuscarStudentAsig {


    @Autowired
    IstudentAsignatureRepositorio studentAsignatureRepositorio;


    StudentAsignature studentAsignature = new StudentAsignature();
    //Persona personaBuscada = new Persona();


    @Override
    public StudentAsignature buscarStudentAsignatureId(String id) throws Exception  //Busca por número id
    {
        studentAsignature = studentAsignatureRepositorio.findById(studentAsignature.id_student).orElseThrow(() -> new NotFoundExceptionToni("Student asignatura. No encuentro id: " + id));
        return studentAsignature;
    }






    /*
    @Override
    public StudentAsignature buscarStudentAsignatureId(String id_student) {


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

        return studentAsignature;
    }  */


}



