package com.oryanend.workshopmongo.services;

import com.oryanend.workshopmongo.models.dto.PostDTO;
import com.oryanend.workshopmongo.models.entities.Post;
import com.oryanend.workshopmongo.repositories.PostRepository;
import com.oryanend.workshopmongo.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    @Autowired
    private PostRepository repository;

    public PostDTO findById(String id){
        Post entity = getEntityById(id);
        return new PostDTO(entity);
    }

    public Post getEntityById(String id){
        Optional<Post> result = repository.findById(id);
        return result.orElseThrow(() -> new ResourceNotFoundException("Objeto não encontrado"));
    }

    public List<PostDTO> findByTitle(String text) {
        List<Post> list = repository.searchTitle(text);
        return list.stream().map(PostDTO::new).toList();
    }

    public List<PostDTO> fullSearch(String text, String start, String end) {
        Instant startMoment = convertMoment(start, Instant.ofEpochMilli(0L));
        Instant endMoment = convertMoment(end, Instant.now());
        List<Post> list = repository.fullSearch(text, startMoment, endMoment);
        return list.stream().map(PostDTO::new).toList();
    }

    private Instant convertMoment(String originalString, Instant alternative) {
        try {
            return Instant.parse(originalString);
        } catch (DateTimeParseException e) {
            return alternative;
        }
    }


}
