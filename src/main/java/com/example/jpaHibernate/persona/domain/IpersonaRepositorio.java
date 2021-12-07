package com.example.jpaHibernate.persona.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IpersonaRepositorio extends JpaRepository<Persona, Integer> {

        //@Query ("select u from Usuario u where u.nombre like :nombreBuscado order by u.name")
        //List<Persona>buscaPorNombre(@Param("nombreBuscado") String name);

    }





//@Query("select p from Persona p where p.name like :nombreBuscado order by p.name")




