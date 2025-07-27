package com.example.library.service;

import com.example.library.repository.BookRepository;

import java.util.List;

public class BookService {
    private BookRepository bookRepository;

    // Setter for Dependency Injection
    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void displayBooks() {
        List<String> books = bookRepository.getBooks();
        System.out.println("Available Books:");
        books.forEach(System.out::println);
    }
}