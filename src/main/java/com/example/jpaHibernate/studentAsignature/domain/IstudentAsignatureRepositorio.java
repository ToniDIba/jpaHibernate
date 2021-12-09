package com.example.jpaHibernate.studentAsignature.domain;

import com.example.jpaHibernate.student.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IstudentAsignatureRepositorio extends JpaRepository<StudentAsignature, String> {


    }






