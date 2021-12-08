package com.example.jpaHibernate.student.domain;

import com.example.jpaHibernate.persona.domain.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstudentRepositorio extends JpaRepository<Student , String> {


    }






