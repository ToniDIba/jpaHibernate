package com.example.jpaHibernate.persona.infrastructure.controller;


import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.IFeignServer;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestTemplateController {

    @GetMapping("/template/{idProfesor}")
    ResponseEntity<DtoProfesorStudent> callUsingRestTemplate(@PathVariable String idProfesor) {
        System.out.println("En entrada restTemplate. Antes de llamar pasándole: " + idProfesor);

        ResponseEntity<DtoProfesorStudent> rs;
        rs = new RestTemplate().getForEntity("http://localhost:8085/profesor/id/" + idProfesor, DtoProfesorStudent.class);

        return ResponseEntity.ok(rs.getBody());

    }

}
