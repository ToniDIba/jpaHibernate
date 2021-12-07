package com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa;

import com.example.jpaHibernate.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.List;

@Repository
public interface IpersonaRepositorio extends JpaRepository<Persona, Integer> {

        //@Query ("select u from Usuario u where u.nombre like :nombreBuscado order by u.name")
        //List<Persona>buscaPorNombre(@Param("nombreBuscado") String name);

    }





//@Query("select p from Persona p where p.name like :nombreBuscado order by p.name")




