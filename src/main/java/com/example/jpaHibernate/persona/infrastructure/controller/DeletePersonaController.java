package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.application.port.IBorrarPersona;
import com.example.jpaHibernate.persona.application.port.IBuscarPersona;
import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
public class DeletePersonaController {


    @Autowired
    IvalidacionesService validacionesService;

    @Autowired
    IBorrarPersona borrarPersona;


    @Autowired
    IBuscarPersona buscarPersona;

    @DeleteMapping("/id/delete/{idOrName}")
    public Persona borrarPorNombreOrId(@PathVariable String idOrName) throws Exception
    {

        Persona persBuscada = null;
        String claveBusqueda = validacionesService.retornarIdOrName(idOrName);

        if(isNumeric(claveBusqueda)) {
            persBuscada = borrarPersona.borrarPersonaId(Integer.parseInt(claveBusqueda)); //Busca por id numérico
        }
        else {
            persBuscada = borrarPersona.borrarPersona(claveBusqueda);  //Busca por nombre persona para borrarla
        }

        return persBuscada;
    }



    public static boolean isNumeric(String str)
    {
        return str != null && str.matches("[-+]?\\d*\\.?\\d+");
    }


}
