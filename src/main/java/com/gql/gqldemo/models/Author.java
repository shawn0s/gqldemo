package com.gql.gqldemo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Author")
@Data
public class Author {

    @Id
    private String id;
    private String firstName;
    private String lastName;

}
