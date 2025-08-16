package com.prep.interview.library_management_system.service;

import com.prep.interview.library_management_system.Generator.BookIdGenerator;
import com.prep.interview.library_management_system.Repo.BookRepo;
import com.prep.interview.library_management_system.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Year;

@Service
public class BookService {

    private final BookRepo bookRepo;


    @Autowired
    BookService(BookRepo bookRepo){
        this.bookRepo=bookRepo;
    }

    public void addBookToLib(String title, String author , Year publishedYear ){
        Book book= new Book(BookIdGenerator.getId(),title,author,publishedYear);
        bookRepo.addBook(book);
        System.out.printf("Book has been added successfully with id %d\n",book.getId());
    }

    public Book findBookByTitle(String title){
        return bookRepo.getBookByTitle(title);
    }

    public Book findBookById(int id){
        return bookRepo.getBookById(id);
    }


    public Book findBookByAuthor(String author){
        return bookRepo.getBookByAuthor(author);
    }

    public void removeBook(String bookName){
        bookRepo.deleteBook(bookName);
    }


}
