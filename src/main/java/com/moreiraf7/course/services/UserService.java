package com.moreiraf7.course.services;

import com.moreiraf7.course.entities.User;
import com.moreiraf7.course.repositories.UserRepository;
import com.moreiraf7.course.services.exception.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // Registra a classe como um componente do spring
public class UserService {

    @Autowired
    private UserRepository repository; // injeção de depêndencia automática

    //Metodo para retornar todos os users
    public List<User> findAll() {
        return repository.findAll();
    }

    //Metodo para encontrar o user pelo id
    public User findById(Long id) {
        Optional<User> obj = repository.findById(id);
        // Tenta retornar o obj, se não conseguir retorna uma exceção
        return obj.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    //Operação basica para inserir no banco de dados um novo objeto do tipo User
    public User insert(User obj) {
        return repository.save(obj);
    }

    //Operação básica para deletar um objeto User
    public void delete(Long id) {
        repository.deleteById(id);
    }

    //Operações para atualizar o objeto User
    public User update(Long id, User obj){
        User entity = repository.getReferenceById(id);
        updateData(entity, obj);
        return repository.save(entity);
    }

    private void updateData(User entity, User obj) {
        entity.setName(obj.getName());
        entity.setEmail(obj.getEmail());
        entity.setPhone(obj.getPhone());
    }
}
