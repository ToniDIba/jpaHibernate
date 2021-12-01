package com.example.jpaHibernate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Book;
import java.util.List;

@Repository
public interface IpersonaRepositorio extends JpaRepository<Persona, Integer> {

    @Query("select p from Persona p where p.name like :nombreBuscado order by p.name")
    List<Persona> buscaPorNombre(@Param("nombreBuscado") String nombreBuscado);

}

