package com.example.jpaHibernate;

import com.example.jpaHibernate.content.application.port.IanadirPersona;
import com.example.jpaHibernate.content.application.port.IbuscarTodos;
import com.example.jpaHibernate.infrastructure.controller.dto.repository.jpa.IpersonaRepositorio;
import com.example.jpaHibernate.content.application.port.IvalidacionesService;
import com.example.jpaHibernate.infrastructure.controller.dto.input.InputDto;
import com.example.jpaHibernate.infrastructure.controller.dto.output.DatosPersonaDTO;
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

    @Autowired
    IanadirPersona anadirPersona;

    @Autowired
    IbuscarTodos ibuscarTodos;




    @PostMapping
    public Persona anadirPersona(@RequestBody InputDto inputDto) {

        Persona miPers = validacionesService.mapearInputOutput(inputDto);
        anadirPersona.anyadirPersona(miPers);
        return miPers;
    }




    /**
     * Retorna todas las personas existentes en la tabla
     * @return
     */

    @GetMapping("/todos")
    public List<Persona> todasPersonas() {
        return ibuscarTodos.buscarTodos();

    }




    @GetMapping("/{idOrName}")
    public Persona consultaPorNombreOrId(@PathVariable String idOrName) {

        Optional<Integer> idParam = Optional.empty();
        Optional<String> nombreParam = Optional.empty();
        String nombreBuscado = null;

        //Persona persBuscada = null;
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

            /*-------------------------------------------------------------------------------------------------------
            //Con @Query (ver clase "IpersonaRepositorio")
            List<Persona> hallados = personaRepositorio.buscaPorNombre(nombreBuscado);
            System.out.println("Hallados: " + hallados.get(0).getName() + " " + hallados.get(0).getUsuario());*/

            //Select de otra forma: (necesitas archivo "persistence.xml" dentro de resources/META-INF
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("UnidadPersonas");
            EntityManager em = emf.createEntityManager();
            TypedQuery<Persona> query = em.createQuery("SELECT p FROM Persona p WHERE p.name = '" + nombreBuscado + "'", Persona.class);



            Persona personaBuscada = null;
            try {

                personaBuscada = query.getSingleResult();

                //Normalmente los DTO se hacen con más de una "entity"(tabla).
                //Ver ejemplo en: https://www.arquitecturajava.com/jpa-dto-data-transfer-object-y-jpql/ (busca dentro "Enfoque diferente")
                List<DatosPersonaDTO> lista=em.createQuery("select distinct new com.example.jpaHibernate.infrastructure.controller.dto.output.DatosPersonaDTO(p.name) from Persona p", DatosPersonaDTO.class).getResultList();
                System.out.println("Con DTO: " + lista.get(0).getName());

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

