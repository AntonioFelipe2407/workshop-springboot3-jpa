package com.moreiraf7.course.resources;

import com.moreiraf7.course.entities.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //Anotation para informar que essa class se trata de um recurso web implementado por um controlador rest
@RequestMapping(value = "/users") //Anotation para dar o nome ao recurso
public class UserResource {

    //Criando um metodo de teste que será um ending point para acessar os usuários

    @GetMapping // Anotation que diz que o metodo responde a requisiçao do tipo get de um http
    public ResponseEntity<User> findAll(){
        User u = new User(1L, "maria", "maria@gmail.com", "9999999", "12345");
        return ResponseEntity.ok().body(u);
    }
}
