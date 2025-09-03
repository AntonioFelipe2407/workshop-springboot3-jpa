package com.moreiraf7.course.repositories;

import com.moreiraf7.course.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order,Long> {
    //Ja contém uma implementação padrão
}
