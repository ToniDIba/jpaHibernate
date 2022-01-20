package com.example.jpaHibernate.persona.infrastructure.controller;

import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.domain.Parametros;
import com.example.jpaHibernate.persona.domain.Persona;
import com.example.jpaHibernate.persona.infrastructure.controller.dto.input.InputDto;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class ValidacionesServiceImpl implements IvalidacionesService {

    public static String token;

    @Autowired
    IpersonaRepositorio ipersonaRepositorio;


    @Override
    //public void validarInfoPersona(InputDto inputDto) {
    public void validarInfoPersona(Persona pers) {

        String resu = "ok";

        System.out.println("id_persona : " + pers.getId_personpers());
        System.out.println("city : " + pers.getCity());
        System.out.println("company_email: " + pers.getCompany_email());
        System.out.println("created_date: " + pers.getCreated_date());
        System.out.println("imagen_url: " + pers.getImagen_url());
        System.out.println("name : " + pers.getName());
        System.out.println("password : " + pers.getPassword());
        System.out.println("personal_email: " + pers.getPersonal_email());
        System.out.println("surname : " + pers.getSurname());
        System.out.println("termination:date: " + pers.getTermination_date());
        System.out.println("usuario: " + pers.getUsuario());

        if (pers.getName() == null || pers.getName().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Name es null";

        if (pers.getUsuario() == null || pers.getUsuario().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<< Usuario es null";

        if (pers.getUsuario().length() < 6)
            resu = " <<<<<<<<<<<<<<<<<<<<<<<<<<<<< usuario < 6";

        if (pers.getUsuario().length() > 10)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< usuario > 10";

        if (pers.getPassword() == null || pers.getPassword().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Password es null";

        if (pers.getPersonal_email() == null || pers.getPersonal_email().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Personal mail es null";

        if (pers.getCompany_email() == null || pers.getCompany_email().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< Company mail es null";

        if (pers.getCity() == null || pers.getCity().length() == 0)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<< City es null";

        if (pers.getCreated_date() == null)
            resu = "<<<<<<<<<<<<<<<<<<<<<<<<<<<< Name es null";

        if (!resu.equals("ok")) {
            NullPointerException nullPointer = new NullPointerException("Error controlado");
            throw nullPointer;
        }

        // return new Persona();
    }


    public Persona mapearInputOutput(InputDto inputDto) {

        Persona personaOut = new Persona();

        personaOut.setId_personpers(inputDto.getId_personapers());
        personaOut.setUsuario(inputDto.getUsuario());
        personaOut.setPassword(inputDto.getPassword());
        personaOut.setName(inputDto.getName());
        personaOut.setSurname(inputDto.getSurname());
        personaOut.setCompany_email(inputDto.getCompany_email());
        personaOut.setPersonal_email(inputDto.getPersonal_email());
        personaOut.setCity(inputDto.getCity());

        personaOut.setActive(inputDto.isActive()); //Boolean
        personaOut.setAdmin(inputDto.isAdmin()); //Boolean

        personaOut.setCreated_date(inputDto.getCreated_date());
        personaOut.setImagen_url(inputDto.getImagen_url());
        personaOut.setTermination_date(inputDto.getTermination_date());

        return personaOut;


    }

    @Override
    public String retornarIdOrName(String idOrName) {

        Optional<Integer> idParam = Optional.empty();
        Optional<String> nombreParam;

        idOrName = idOrName.trim();
        String nombreBuscado = null;

        try {
            idParam = Optional.ofNullable(Integer.parseInt(idOrName));         // Busca por "Id";
        } catch (NumberFormatException nfe) {
            nombreParam = Optional.ofNullable(idOrName);
            nombreBuscado = nombreParam.get();                                //Busca por "Name"
        }

        if (idParam.isPresent()) {
            return idParam.get().toString();
        } else {
            return nombreBuscado;
        }

    }

    @Override
    public void comprobarName(String nombre, Parametros params) {

        params.setName(nombre);
    }



    @Override
    public boolean validarPasswordYUsuario(String user, String password) {

        Persona miPersona;

        List<Persona> personaList = new ArrayList<>();
        personaList = ipersonaRepositorio.findPersonaByUsuario(user);
        miPersona = personaList.get(0);

        if ((miPersona.getUsuario().equals(user)) && (miPersona.getPassword().equals(password))) {
            if (miPersona.isAdmin() == true) LoginController.esAdmin = true; // "esAdmin" declarada "static" en "LoginController"
            return true;
        }

        return false;

    }



    @Override
    public String getJWTToken(String username) {

        String secretKey = "mySecretKey";
        List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

          //String token = Jwts  <<< "token", declarada static más arriba
          token = Jwts
                .builder()
                .setId("softtekJWT")
                .setSubject(username)
                .claim("authorities",
                        grantedAuthorities.stream()
                                .map(GrantedAuthority::getAuthority)
                                .collect(Collectors.toList()))
                .setIssuedAt(new Date(System.currentTimeMillis()))
              //.setExpiration(new Date(System.currentTimeMillis() + 990000)) // + 16 minutos
              //.setExpiration(new Date(System.currentTimeMillis() + 600000)) // + 10 minutos
                .setExpiration(new Date(System.currentTimeMillis() + 300000)) // + 05 minutos
                .signWith(SignatureAlgorithm.HS512,
                        secretKey.getBytes()).compact();

        return "Bearer " + token;
    }




}