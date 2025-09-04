package com.moreiraf7.course.repositories;

import com.moreiraf7.course.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    //Ja contém uma implementação padrão
}
