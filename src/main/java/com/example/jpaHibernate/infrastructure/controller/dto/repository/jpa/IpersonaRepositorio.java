package com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa;

import com.example.jpaHibernate.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IpersonaRepositorio extends JpaRepository<Persona, Integer> {

   //List<Persona> buscaPorNombre(@Param("nombreBuscado") String nombreBuscado);

}





//@Query("select p from Persona p where p.name like :nombreBuscado order by p.name")

