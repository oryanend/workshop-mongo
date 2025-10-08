package com.oryanend.workshopmongo.repositories;

import com.oryanend.workshopmongo.models.entities.Post;
import com.oryanend.workshopmongo.models.entities.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
    
}
