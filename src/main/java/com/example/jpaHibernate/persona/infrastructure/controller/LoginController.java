package com.example.jpaHibernate.persona.infrastructure.controller;


import com.example.jpaHibernate.persona.application.port.IvalidacionesService;
import com.example.jpaHibernate.persona.domain.IpersonaRepositorio;
import com.example.jpaHibernate.persona.domain.Persona;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@RestController
@Data
public class LoginController {

    @Autowired
    IvalidacionesService ivalidacionesService;

    //Al ser estáticas, puedo acceder a ellas desde cualquier otra clase ("LoginController.esAdmin = true;")
    public static boolean esAdmin = false;
    public static boolean passCorrecto = false;



    //http://localhost:8085/login?usuario=usuario8&password=pass8
    @PostMapping("login")
    public ResponseEntity<String> login(@RequestParam("usuario")  Optional<String> miusuario,
                                        @RequestParam("password") Optional<String> mipassword)
    {

        String user = miusuario.isPresent()  ?  miusuario.get() : "Debe informar un usuario por el que buscar...";
        String pass = mipassword.isPresent() ? mipassword.get() : "Debe informar un password...";

        //Verifica en tabla que, para este usuario, su password sea el que dice
        passCorrecto = ivalidacionesService.validarPasswordYUsuario(user, pass);

        if(!passCorrecto) return new ResponseEntity<>("Combinación no válida: " + user + " " + pass, HttpStatus.OK);

        String token = ivalidacionesService.getJWTToken(user); //Token seguridad

        System.out.println("Desde LoginController. EsAdmin: " + esAdmin);

        return new ResponseEntity<>(user + ".   " + pass + " " + token, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}


// http://localhost:8085/login/unusuario,unpassword

//@RequestMapping(value = {"/login/", "/login/{usuario},", "/login/{usuario},{password}"})
//
//public ResponseEntity<String> login(@PathVariable("usuario")  Optional<String> miusuario,
//                                    @PathVariable("password") Optional<String> mipassword)
//{