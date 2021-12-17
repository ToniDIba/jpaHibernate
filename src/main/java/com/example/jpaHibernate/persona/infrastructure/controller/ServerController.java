package com.example.jpaHibernate.persona.infrastructure.controller;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("server")
public class ServerController {

    @GetMapping("{idProfesor}")
    ResponseEntity<String> gethttpcode(@PathVariable int idProfesor)
    {

        System.out.println("En server. retornare: " + idProfesor);
        return ResponseEntity.status(idProfesor).body("retorno: " + idProfesor);

    }


}
