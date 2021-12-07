package com.example.jpaHibernate.student.infrastructure.controller;

import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.domain.Persona;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class ConsultaStudentController {


    @Autowired
    IpersonaRepositorio personaRepositorio;

    @Autowired
    IvalidacionesService validacionesService;

    @Autowired
    IBuscarPersona buscarPersona;



    @GetMapping("/id/{idOrName}")
    public Persona consultaPorNombreOrId(@PathVariable String idOrName) throws Exception
    {

        Persona persBuscada = null;
        String claveBusqueda = validacionesService.retornarIdOrName(idOrName);


        if(isNumeric(claveBusqueda)) {
             persBuscada = buscarPersona.buscarPersonaId(claveBusqueda); //Busca por id numérico
        }
        else {
            persBuscada = buscarPersona.buscarPersona(claveBusqueda);  //Busca por nombre persona
        }


        return persBuscada;

    }

    public static boolean isNumeric(String str)
    {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }



}
