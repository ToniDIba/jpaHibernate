package com.example.jpaHibernate;


import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.*;


import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;


@RestController
public class Controlador {

    @Autowired
    IpersonaRepositorio personaRepositorio;

    @Autowired
    IvalidacionesService validacionesService;



    /* Retorna todos
    @GetMapping("/todos")
    public List<Persona> todasPersonas()
    {
        return personaRepositorio.findAll();
    } */


    @GetMapping("/{idOrName}")
    public Persona consultaPorNombreOrId(@PathVariable String idOrName) {

        Optional<Integer> idParam = Optional.empty();
        Optional<String> nombreParam = Optional.empty();

        Persona persBuscada = null;

        idOrName = idOrName.trim();


        //FastFail
        if (idOrName.length() == 0) {
            persBuscada = new Persona();
            persBuscada.setSurname("No existe persona con este id / nombre: " + idOrName);

        }
        /* *
         * Extrae de param "idOrName" un 'int' correspondiente al 'id', o un String correspondiente al nombre buscado
         * */
        try {
            idParam = Optional.ofNullable(Integer.parseInt(idOrName));
            persBuscada = personaRepositorio.findById(idParam.get()).get();
        } catch (NoSuchElementException e) {
            nombreParam = Optional.ofNullable(idOrName);

            /*@Query
            persBuscada = personaRepositorio.findBy()*/

            //persBuscada = personaRepositorio.fin
        }


        if (Objects.isNull(persBuscada)) {
            persBuscada = new Persona();

            String mensaje = idParam.isPresent() ? " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   No existe persona con este id: " + idParam.get() :
                    "No existe persona con este nombre: " + nombreParam;
            persBuscada.setSurname(mensaje);
        }

        return persBuscada;


    }

/*
    @GetMapping("/{id_persona}")
    public Persona buscaPersonaPorId (@PathVariable int id_persona) throws Exception {

        Persona persBuscada = null;

        try {
            persBuscada = personaRepositorio.findById(id_persona).get();
        }
        catch (NoSuchElementException e) {
            persBuscada = new Persona();
            persBuscada.setSurname("No existe persona con este id: " + id_persona);
        }

        return persBuscada;
    } */


    @PostMapping
    public Persona anadirPersona(@RequestBody Persona persona) {
        System.out.println("Añadiendo persona con POST desde Controlador...");

        String resultado = validacionesService.validarInfoPersona(persona);

        if (resultado.equals("ok")) {
            System.out.println("Validacion correcta");
            personaRepositorio.save(persona);
        } else {
            persona.setName(resultado);
        }


        return persona;
    }

}

