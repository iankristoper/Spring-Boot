package com.system.book;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Component;
import org.springframework.context.ApplicationContext;

import jakarta.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;






@SpringBootApplication
public class BookApplication {
    public static void main(String[] args) {     
        System.out.println("Sping Boot is running on fire...");
        
        //spplicstion context has been loaded 
        ApplicationContext context = SpringApplication.run(BookApplication.class, args);
    }
}

//
@Component
class Library {
    private final List<Book> books = new ArrayList<>();
    private final Book book;
    
    public Library(Book book) {
        System.out.println("Library class has become bean - Library.class");
        this.book = book;
    }
    
    @PostConstruct
    public void initLibrary() {
        System.out.println("Initializing Library...");
        books.add(book);
        System.out.println("Library initialized");
    }
    
    public void displayBooks() {
        System.out.println("Library books list...");
        
        for(Book book : books) {
            System.out.println("Title: " + book.getTitle());
            System.out.println("Author: " + book.getAuthorName());
        }
    }
}

//
@Component 
class Book {
    private final String title;
    private final Author author;
    
    public Book(Author author) {
        System.out.println("Book class has become bean - Book.class");
        this.title = "Spring Boot for Beginners";
        this.author = author;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getAuthorName() {
        return author.getName();
    }
}

//
@Component
class Author {
    private final String name = "Ian";
    
    public Author() {
        System.out.println("Author class has become bean - Author.class");        
    }
    
    public String getName() {
        return name;
    }
}
