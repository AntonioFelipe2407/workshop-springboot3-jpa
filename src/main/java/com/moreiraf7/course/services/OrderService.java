package com.moreiraf7.course.services;

import com.moreiraf7.course.entities.Order;
import com.moreiraf7.course.entities.Order;
import com.moreiraf7.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Registra a classe como um componente do spring
public class OrderService {

    @Autowired
    private OrderRepository repository; // injeção de depêndencia automática

    //Metodo para retornar todos os users
    public List<Order> findAll() {
        return repository.findAll();
    }

    //Metodo para encontrar o user pelo id
    public Order findById(Long id) {
        Optional<Order> obj = repository.findById(id);
        return obj.get(); // retorna o objeto do tipo user que estiver dentro de obj
    }
}
