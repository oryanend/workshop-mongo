package com.oryanend.workshopmongo.services;

import com.oryanend.workshopmongo.models.dto.UserDTO;
import com.oryanend.workshopmongo.models.entities.User;
import com.oryanend.workshopmongo.repositories.UserRepository;
import com.oryanend.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserDTO::new).toList();
    }

    public UserDTO findById(String id){
        Optional<User> result = repository.findById(id);
        User entity = result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
        return new UserDTO(entity);
    }

    public UserDTO insert(UserDTO dto){
        User entity = new User();
        copyDtoToEntity(dto, entity);
        entity = repository.insert(entity);
        return new UserDTO(entity);
    }

    private void copyDtoToEntity(UserDTO dto, User entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
    }

}
