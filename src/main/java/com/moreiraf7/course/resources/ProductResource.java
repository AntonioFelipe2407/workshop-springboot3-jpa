package com.moreiraf7.course.resources;

import com.moreiraf7.course.entities.Product;
import com.moreiraf7.course.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController //Anotation para informar que essa class se trata de um recurso web implementado por um controlador rest
@RequestMapping(value = "/products") //Anotation para dar o nome ao recurso
public class ProductResource {

    @Autowired
    private ProductService service;

    //Endpoint para buscar todas as categorias
    @GetMapping
    public ResponseEntity<List<Product>> findAll() {
        List<Product> list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    //Endpoint para buscar Id
    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable Long id){
        Product obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
