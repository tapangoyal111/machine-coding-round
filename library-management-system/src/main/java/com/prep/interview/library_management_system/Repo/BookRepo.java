package com.prep.interview.library_management_system.Repo;


import com.prep.interview.library_management_system.Generator.BookIdGenerator;
import com.prep.interview.library_management_system.Matcher.CompleteFieldMatcher;
import com.prep.interview.library_management_system.Matcher.FieldMatcher;
import com.prep.interview.library_management_system.Matcher.PartialFieldMatcher;
import com.prep.interview.library_management_system.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.time.LocalDate;
import java.time.Year;
import java.util.HashMap;
import java.util.Map;

@Service
public class BookRepo {

    private final CompleteFieldMatcher completeFieldMatcher;

    @Autowired
    BookRepo(CompleteFieldMatcher completeFieldMatcher){
        this.completeFieldMatcher=completeFieldMatcher;
    }
    private static Map<Integer , Book> bookMap = new HashMap<>();

    public void addBook(Book book ){
//        May include some authentication/other checks to add a book (like admin , BookKeeper)
        bookMap.put(book.getId(),book);
    }


    public Book getBookByTitle(String title) {
        try{
            return completeFieldMatcher.findBook(bookMap,title,Book.class.getField("title"));
        }
        catch(Exception e){
            System.out.println("Field Type doesn't exist in Book class "+ e.toString());
            return null;
        }
    }

    public Book getBookByAuthor(String author) {
        try{
            return completeFieldMatcher.findBook(bookMap,author,Book.class.getField("author"));
        }
        catch(Exception e){
            System.out.println("Field Type doesn't exist in Book class "+ e.toString());
            return null;
        }
    }

    public Book getBookById(int id) {
        return bookMap.get(id);
    }

    public void deleteBook(String bookName) {
        for(Book book:bookMap.values()){
            if(book.getTitle().equals(bookName)){
                if(book.getAvailableCopies()==book.getTotalCopies()){
                    bookMap.remove(book);
                    return;
                }
                else{
                    System.out.println("There are still some copy issued for this book.\n !! Can't remove this one");
                    return;
                }
            }
        }
        System.out.println("Couldn't find any book with this name");
    }
}
