package com.moreiraf7.course.repositories;

import com.moreiraf7.course.entities.OrderItem;
import com.moreiraf7.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem,Long> {
    //Ja contém uma implementação padrão
}
