package com.example.jpaHibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.persistence.*;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;


@RestController
public class Controlador {

    @Autowired
    IpersonaRepositorio personaRepositorio;

    @Autowired
    IvalidacionesService validacionesService;




    /**
     * En "R E S O U R C E S" tienes archivo "plantillaPersonaJSON.txt" con datos para insertar en la tabla
     * Tras validarla, añade persona a la tabla
     */

    @PostMapping
    public Persona anadirPersona(@RequestBody Persona persona) {

        String resultado = validacionesService.validarInfoPersona(persona);

        if (resultado.equals("ok")) {
            personaRepositorio.save(persona);
        } else {
            persona.setName(resultado); //En "resultado" viene la descripción del error
        }

        return persona;
    }





    /**
     * Retorna todas las personas existentes en la tabla
     */

    @GetMapping("/todos")
    public List<Persona> todasPersonas() {
        return personaRepositorio.findAll();
    }


    @GetMapping("/{idOrName}")
    public Persona consultaPorNombreOrId(@PathVariable String idOrName) {

        Optional<Integer> idParam = Optional.empty();
        Optional<String> nombreParam = Optional.empty();
        String nombreBuscado = null;

        Persona persBuscada = null;
        idOrName = idOrName.trim();


        /**
         * Extrae del parámetro de la URL, un numérico o un String para buscar por "Id" / "Nombre"
         */

        try {
            idParam = Optional.ofNullable(Integer.parseInt(idOrName));         // Busca por "Id"
            persBuscada = personaRepositorio.findById(idParam.get()).get();
        } catch (NumberFormatException nfe) {

            nombreParam = Optional.ofNullable(idOrName);
            nombreBuscado = nombreParam.get();                                //Busca por "Name"

            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
            EntityManager em = emf.createEntityManager();

            // cómo se haría con @Query ??
            // cómo encaja @Native ??
            TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.name = '" + nombreBuscado + "'", Persona.class);

            Persona personaBuscada = null;
            try {
                personaBuscada = query.getSingleResult();

                persBuscada = new Persona();
                persBuscada.setName(personaBuscada.getName());
                persBuscada.setPassword(personaBuscada.getPassword());
                persBuscada.setUsuario(personaBuscada.getUsuario());

            } catch (NoResultException nre) {   //Query no retorna nada
                persBuscada = new Persona();
                String mensaje = " >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   No existe persona con este nombre: " + nombreBuscado;
                persBuscada.setSurname(mensaje);
            }

        } catch (NoSuchElementException nse) {
            persBuscada = new Persona();
            String mensaje = ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>   No existe persona con este id: " + idParam.get();
            persBuscada.setSurname(mensaje);
        }

        return persBuscada;

    }

}

