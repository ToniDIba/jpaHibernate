package com.example.jpaHibernate;

import com.example.jpaHibernate.content.application.port.IBuscarPersona;
import com.example.jpaHibernate.content.application.port.IvalidacionesService;
import com.example.jpaHibernate.infrastructure.controller.dto.output.DatosPersonaDTO;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;


@RestController
public class ConsultaPersonaController {


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
