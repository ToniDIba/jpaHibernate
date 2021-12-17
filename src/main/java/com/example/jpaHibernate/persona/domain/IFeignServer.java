package com.example.jpaHibernate.persona.domain;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "simpleFeign", url = "http://localhost:8085/")
public interface IFeignServer {

    @GetMapping("server/{id}")
    ResponseEntity<String> callServer(@PathVariable("id") int httpcode);

}
