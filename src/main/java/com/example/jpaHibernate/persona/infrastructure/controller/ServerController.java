package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("server")
public class ServerController {

    @GetMapping("{idProfesor}")
    ResponseEntity<DtoProfesorStudent> gethttpcode(@PathVariable String idProfesor) {

        System.out.println("En server con llamada feign. retornaré datos de profesor en port 8086: " + idProfesor);
        ResponseEntity<DtoProfesorStudent> rs;
        rs = new RestTemplate().getForEntity("http://localhost:8086/profesor/id/" + idProfesor, DtoProfesorStudent.class);
        return ResponseEntity.ok(rs.getBody());
    }

}
