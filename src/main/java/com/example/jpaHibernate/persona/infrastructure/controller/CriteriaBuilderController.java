package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.persona.domain.Parametros;
import com.example.jpaHibernate.persona.domain.Persona;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import javax.persistence.criteria.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


// http://localhost:8085/criteriabuild/columnas?surname=López&user=1&fechahigh=2005-06-01 00:00:00&fechalow=2027-07-01 00:00:00&ordenarpor=user&name=Toni&primerRegARecuperar=8




@RestController
@RequestMapping("/criteriabuild")
public class CriteriaBuilderController
{

    @PersistenceContext
    private EntityManager entityManager;

    @RequestMapping(value = {"/columnas",
                             "/columnas/{user}",
                             "/columnas/{user} ? {name} ? {surname} ? {fechahigh} ? {fechalow} ? {ordenarpor} ? {primerRegARecuperar}"}, method = RequestMethod.GET)


    public List seleccionarPersonas(Parametros params) throws ParseException {

        System.out.println("User   : " + params.getPrimerRegARecuperar());

        //Convierte parámetro entrada fechaDesde / fechaHasta a un "Date"
        Date ParamFechaHasta = stringADate(params.getFechahigh());
        Date ParamFechaDesde = stringADate(params.getFechalow());

        // Parejas(Columna - Valor) recibidos de PostMan, para el "Where"
        HashMap<String, Object> condicionesWhere = llenarHash(params, ParamFechaDesde, ParamFechaHasta);

        //Personas que cumplen las condiciones del Where
        List persHalladas = new ArrayList();
        persHalladas = getData(condicionesWhere, params);

        return persHalladas;

    }


    //Select sobre tabla "Persona", para retornar las que cumplan el "Where"
    public List<Persona> getData(HashMap<String, Object> condicionesWhere, Parametros params) {

        int primerRegARecuperar = params.getPrimerRegARecuperar() - 1;
        int numFilasMostrar = 3;

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Persona> query = cb.createQuery(Persona.class);
        Root<Persona> root = query.from(Persona.class);
        List<Predicate> condiciones = new ArrayList<>();

        condicionesWhere.forEach((nombreColumna, valorColumna) ->
        {
            switch (nombreColumna) {

                case "usuario":
                    if (valorColumna != null) condiciones.add(cb.equal(root.get(nombreColumna), (String) valorColumna));
                    break;

                case "name":
                    if (valorColumna != null)
                        condiciones.add(cb.like(root.get(nombreColumna), "%" + (String) valorColumna + "%"));
                    break;

                case "surname":
                    if (valorColumna != null)
                        condiciones.add(cb.like(root.get(nombreColumna), "%" + (String) valorColumna + "%"));
                    break;

                case "fechaDesde":
                    if (valorColumna != null) {
                        Date fechaDesde = (Date) condicionesWhere.get("fechaDesde");
                        condiciones.add(cb.greaterThan(root.<Date>get("created_date"), (Date) valorColumna));
                    }
                    break;

                case "fechaHasta":
                    if (valorColumna != null) {
                        Date fechaHasta = (Date) condicionesWhere.get("fechaHasta");
                        condiciones.add(cb.lessThan(root.<Date>get("created_date"), (Date) valorColumna));
                    }
                    break;
            }

        });

        if (condiciones.size() == 0) return new ArrayList<Persona>(); //El "WHERE" está vacío. Retorno nada

        query.select(root).where(condiciones.toArray(new Predicate[condiciones.size()]));
        if (params.getOrdenarpor() != null) query.orderBy(cb.asc (root.get(params.getOrdenarpor())));  //Ascending
        //                                  query.orderBy(cb.desc(root.get(params.getOrdenarpor()))); //Descending


        List<Persona> personaList = entityManager.createQuery(query)
                                                 .setMaxResults(numFilasMostrar)
                                                 .setFirstResult(primerRegARecuperar)
                                                 .getResultList();

        return personaList;

    }


    // Parejas(Columna - Valor) para el "Where"
    private HashMap<String, Object> llenarHash(Parametros params, Date desde, Date hasta) {

        HashMap<String, Object> hm = new HashMap<>();

        System.out.println("User   : " + params.getUser());
        System.out.println("Name   : " + params.getName());
        System.out.println("Surname: " + params.getSurname());
        System.out.println("Fecha h: " + params.getFechahigh());
        System.out.println("Fecha l: " + params.getFechalow());
        System.out.println("Orden x: " + params.getOrdenarpor());
        System.out.println("1er reg a recuperar: " + params.getPrimerRegARecuperar());

        hm.put("usuario", params.getUser());
        hm.put("name", params.getName());
        hm.put("surname", params.getSurname());
        hm.put("fechaHasta", hasta);
        hm.put("fechaDesde", desde);
        hm.put("ordenarPor", params.getOrdenarpor());

        return hm;
    }


    //Formatea a "Date" el String recibido desde PostMan
    private Date stringADate(String fechaIn) throws ParseException {

        Date unaFecha = new Date();
        if (fechaIn == null) unaFecha = null;

        if (fechaIn != null) unaFecha = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(fechaIn);

        return unaFecha;

    }


}

