package com.moreiraf7.course.services;

import com.moreiraf7.course.entities.Product;
import com.moreiraf7.course.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Registra a classe como um componente do spring
public class ProductService {

    @Autowired
    private ProductRepository repository; // injeção de depêndencia automática

    //Metodo para retornar todas as categorias
    public List<Product> findAll() {
        return repository.findAll();
    }

    //Metodo para encontrar o user pelo id
    public Product findById(Long id) {
        Optional<Product> obj = repository.findById(id);
        return obj.get(); // retorna o objeto do tipo product que estiver dentro de obj
    }
}
