package com.oryanend.workshopmongo.controllers;

import com.oryanend.workshopmongo.models.dto.PostDTO;
import com.oryanend.workshopmongo.models.dto.UserDTO;
import com.oryanend.workshopmongo.services.PostService;
import com.oryanend.workshopmongo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/posts")
public class PostController {

    @Autowired
    private PostService service;

    @Transactional(readOnly = true)
    @GetMapping(value = "/{id}")
    public ResponseEntity<PostDTO> findById(@PathVariable String id){
        PostDTO obj = service.findById(id);
        return ResponseEntity.ok().body(obj);
    }

}
