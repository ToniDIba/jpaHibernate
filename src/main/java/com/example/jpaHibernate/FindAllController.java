package com.example.jpaHibernate;

import com.example.jpaHibernate.content.application.port.IbuscarTodos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FindAllController {

    @Autowired
    IbuscarTodos ibuscarTodos;



    @GetMapping("/todos")
    public List<Persona> todasPersonas() {
        return ibuscarTodos.buscarTodos();

    }





}
