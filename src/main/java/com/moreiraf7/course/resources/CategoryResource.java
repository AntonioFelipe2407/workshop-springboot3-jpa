package com.moreiraf7.course.resources;

import com.moreiraf7.course.entities.Category;
import com.moreiraf7.course.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Anotation para informar que essa class se trata de um recurso web implementado por um controlador rest
@RequestMapping(value = "/categories") //Anotation para dar o nome ao recurso
public class CategoryResource {

    @Autowired
    private CategoryService service;

    //Endpoint para buscar todas as categorias
    @GetMapping
    public ResponseEntity<List<Category>> findAll() {
        List<Category> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint para buscar Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Category> findById(@PathVariable Long id){
        Category obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
