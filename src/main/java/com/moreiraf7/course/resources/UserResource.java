package com.moreiraf7.course.resources;

import com.moreiraf7.course.entities.User;
import com.moreiraf7.course.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController //Anotation para informar que essa class se trata de um recurso web implementado por um controlador rest
@RequestMapping(value = "/users") //Anotation para dar o nome ao recurso
public class UserResource {

    @Autowired
    private UserService service;

    // Ao pesquisar na requisição GET user -> retorna todos os usuarios listados
    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        List<User> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    // Ao pesquisar na requisição GET user/1 -> retorna o usuário com o id pesquisado
    @GetMapping(value = "/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
        User obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User obj){
        obj = service.insert(obj);
        //Gerando um endereço para inserir um recurso
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(obj.getId()).toUri();
        return ResponseEntity.created(uri).body(obj);
    }

}
