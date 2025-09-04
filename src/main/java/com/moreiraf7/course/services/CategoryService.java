package com.moreiraf7.course.services;

import com.moreiraf7.course.entities.Category;
import com.moreiraf7.course.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Registra a classe como um componente do spring
public class CategoryService {

    @Autowired
    private CategoryRepository repository; // injeção de depêndencia automática

    //Metodo para retornar todas as categorias
    public List<Category> findAll() {
        return repository.findAll();
    }

    //Metodo para encontrar o user pelo id
    public Category findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        return obj.get(); // retorna o objeto do tipo category que estiver dentro de obj
    }
}
