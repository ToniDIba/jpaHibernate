package com.example.jpaHibernate.profesor.domain;

import com.example.jpaHibernate.profesor.domain.Profesor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface IprofesorRepositorio extends JpaRepository<Profesor, String> {


}
