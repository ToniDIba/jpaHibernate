package com.example.jpaHibernate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Optional;


@RestController
public class Controlador {

    @Autowired
    IpersonaRepositorio personaRepositorio;

    @Autowired
    IvalidacionesService validacionesService;


    /* Retorna todos
    @GetMapping
    public List<Persona> todasPersonas()
    {
        return personaRepositorio.findAll();
    } */


   //@JsonIgnoreProperties(value={"hibernateLazyInitializer","handler","fieldHandler"})

    @GetMapping("/{id_persona}")
    public Persona getById(@PathVariable int id_persona) throws Exception
    {
        Persona personaBuscada = new Persona();
         personaBuscada = personaRepositorio.getById(id_persona);

       // personaBuscada.setName(personaRepositorio.getById(id).getName());
       // personaBuscada.setSurname(personaRepositorio.getById(id).getSurname());


        return personaBuscada;

    }





    //    http://localhost:8080/h2-console/controlador/add
    @PostMapping
    public Persona anadirPersona(@RequestBody Persona persona) {
        System.out.println("Añadiendo persona con POST desde Controlador...");
        //Persona resultValidacion =  validacionesService.validarColumnas(@RequestBody);

        personaRepositorio.save(persona);
        return persona;
    }

}


