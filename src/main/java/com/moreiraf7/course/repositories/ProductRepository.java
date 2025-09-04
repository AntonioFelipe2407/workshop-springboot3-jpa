package com.moreiraf7.course.repositories;

import com.moreiraf7.course.entities.Category;
import com.moreiraf7.course.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    //Ja contém uma implementação padrão
}
