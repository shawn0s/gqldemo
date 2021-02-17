package com.gql.gqldemo.repositories;

import com.gql.gqldemo.models.Course;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CoureRepository extends MongoRepository<Course,String> {

    @Query(value = "{$and:[{'_id': ?0}")
    Course findById(ObjectId id);
}
