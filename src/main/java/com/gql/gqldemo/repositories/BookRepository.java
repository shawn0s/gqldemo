package com.gql.gqldemo.repositories;

import com.gql.gqldemo.models.Book;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface BookRepository extends MongoRepository<Book,String> {

    @Query(value = "{$and:[{'_id': ?0}")
    Book findById(ObjectId id);
}
