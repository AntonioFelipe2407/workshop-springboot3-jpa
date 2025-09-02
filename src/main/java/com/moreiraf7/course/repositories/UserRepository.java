package com.moreiraf7.course.repositories;

import com.moreiraf7.course.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
    //Ja contém uma implementação padrão
}
