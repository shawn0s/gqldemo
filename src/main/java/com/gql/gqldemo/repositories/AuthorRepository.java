package com.gql.gqldemo.repositories;

import com.gql.gqldemo.models.Author;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface AuthorRepository extends MongoRepository<Author,String> {

    @Query(value = "{$and:[{'_id': ?0}")
    Author findById(ObjectId id);
}
