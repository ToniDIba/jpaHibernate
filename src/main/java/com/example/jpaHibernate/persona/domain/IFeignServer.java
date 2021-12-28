package com.example.jpaHibernate.persona.domain;

import com.example.jpaHibernate.student.application.mappers.DtoProfesorStudent;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8086/profesor/id/")
public interface IFeignServer {

    @GetMapping("/{id}")
    public ResponseEntity<DtoProfesorStudent> callServer(@PathVariable("id") String id);

}


