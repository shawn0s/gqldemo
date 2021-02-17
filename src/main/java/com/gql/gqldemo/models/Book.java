package com.gql.gqldemo.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Book")
public class Book {

    @Id
    private String id;
    private String name;
    private String authorId;
    private int pageCount;
    private Author author;
}
