package com.gql.gqldemo;

import com.google.common.collect.ImmutableMap;
import com.gql.gqldemo.models.Author;
import com.gql.gqldemo.models.Book;
import com.gql.gqldemo.models.Course;
import com.gql.gqldemo.repositories.BookRepository;
import com.gql.gqldemo.repositories.CoureRepository;
import graphql.schema.DataFetcher;
import org.bson.types.ObjectId;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@Component
public class GraphQLDataFetchers {

    @Autowired
    CoureRepository coureRepository;

    @Autowired
    BookRepository bookRepository;

    private static List<Map<String, String>> books = Arrays.asList(
            ImmutableMap.of("id", "book-1",
                    "name", "Harry Potter and the Philosopher's Stone",
                    "pageCount", "223",
                    "authorId", "author-1"),
            ImmutableMap.of("id", "book-2",
                    "name", "Moby Dick",
                    "pageCount", "635",
                    "authorId", "author-2"),
            ImmutableMap.of("id", "book-3",
                    "name", "Interview with the vampire",
                    "pageCount", "371",
                    "authorId", "author-3")
    );

    private static List<Map<String, String>> authors = Arrays.asList(
            ImmutableMap.of("id", "author-1",
                    "firstName", "Joanne",
                    "lastName", "Rowling"),
            ImmutableMap.of("id", "author-2",
                    "firstName", "Herman",
                    "lastName", "Melville"),
            ImmutableMap.of("id", "author-3",
                    "firstName", "Anne",
                    "lastName", "Rice")
    );

    public DataFetcher getBookByIdDataFetcher() {
        return dataFetchingEnvironment -> {
            String bookId = dataFetchingEnvironment.getArgument("id");

            return books
                    .stream()
                    .filter(book -> book.get("id").equals(bookId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher getAuthorDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String,String> book = dataFetchingEnvironment.getSource();
            String authorId = book.get("authorId");
            return authors
                    .stream()
                    .filter(author -> author.get("id").equals(authorId))
                    .findFirst()
                    .orElse(null);
        };
    }

    public DataFetcher createBook() {
        return dataFetchingEnvironment -> {
            Map<String,Object> bookObj = dataFetchingEnvironment.getArgument("input");
            Book book = new Book();
            book.setAuthor(new Author());
            book.setName(bookObj.get("name").toString());
            book.setPageCount((Integer) bookObj.get("pageCount"));
            book.setAuthorId(bookObj.get("authorId").toString());
//            book.setAuthor(new Author());
//            book.getAuthor().setFirstName(bookObj.get("author.firstName"));
//            book.getAuthor().setFirstName(bookObj.get("author.lastName"));
            book = bookRepository.save(book);
            return book;
        };
    }


    public DataFetcher getPageCountDataFetcher() {
        return dataFetchingEnvironment -> {
            Map<String,String> book = dataFetchingEnvironment.getSource();
            return book.get("totalPages");
        };
    }
}
