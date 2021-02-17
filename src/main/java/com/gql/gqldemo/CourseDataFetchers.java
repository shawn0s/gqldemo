package com.gql.gqldemo;

import com.gql.gqldemo.models.Course;
import com.gql.gqldemo.repositories.CoureRepository;
import graphql.schema.DataFetcher;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CourseDataFetchers {

    @Autowired
    CoureRepository coureRepository;

    public DataFetcher getCourseById(){
        return dataFetchingEnvironment -> {
            Course course = null;
            String courseId = dataFetchingEnvironment.getArgument("id");
            try{
                course = coureRepository.findById(new ObjectId(courseId));
            }catch (Exception e){
                e.printStackTrace();
            }


            return course;
        };
    }
}
