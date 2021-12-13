package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import static org.hibernate.query.criteria.internal.ValueHandlerFactory.isNumeric;

@RestController
public class ConsultaPersonaController {

    @Autowired
    IvalidacionesService validacionesService;

    @Autowired
    IBuscarPersona buscarPersona;

    @GetMapping("/id/{idOrName}")
    public Persona consultaPorNombreOrId(@PathVariable String idOrName) throws Exception
    {
        System.out.println("Paso por consultar persona");
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
