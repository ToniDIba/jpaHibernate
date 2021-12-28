package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.IFeignServer;
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
public class ServerController {

    @Autowired
    IFeignServer ifeignserver;

    @GetMapping("server/{id}")
    ResponseEntity<DtoProfesorStudent> callServer(@PathVariable("id") String id) {

        return ifeignserver.callServer(id);

    }

}


