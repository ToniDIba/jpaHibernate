package com.example.jpaHibernate.persona.infrastructure.controller;


import com.example.jpaHibernate.persona.domain.IFeignServer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
@RequestMapping("persona")


public class RestFeignController {

    @Autowired
    IFeignServer iFeignServer;

    @GetMapping("{idProfesor}")
    ResponseEntity<String> callUsingFeign(@PathVariable int idProfesor) {

        System.out.println("En entrada feign. Antes de llamar: " + idProfesor);
        ResponseEntity respuesta = iFeignServer.callServer(idProfesor);
        System.out.println("En entrada feign. Tras llamar: " + idProfesor);

        return respuesta;

    }


    @GetMapping("/template/{idProfesor}")
    ResponseEntity<String> callUsingRestTemplate(@PathVariable int idProfesor) {

        System.out.println("En entrada restTemplate. Antes de llamar: " + idProfesor);
        ResponseEntity rs = new RestTemplate().getForEntity("http://localhost:8085/server/"+idProfesor,String.class);
        System.out.println("En entrada restTemplate. Tras llamar: " + idProfesor);
        return ResponseEntity.ok(rs.getBody().toString());

    }

}
