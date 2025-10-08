package com.oryanend.workshopmongo.services;

import com.oryanend.workshopmongo.models.dto.UserDTO;
import com.oryanend.workshopmongo.models.entities.User;
import com.oryanend.workshopmongo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<UserDTO> findAll() {
        List<User> list = repository.findAll();
        return list.stream().map(UserDTO::new).toList();
    }

}
