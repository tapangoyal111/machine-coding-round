package com.prep.interview.library_management_system.Matcher;

import com.prep.interview.library_management_system.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class CompleteFieldMatcher extends  FieldMatcher{


    @Autowired
    public CompleteFieldMatcher(@Qualifier("partialFieldMatcher") FieldMatcher fieldMatcher){
        this.nextFieldMatcher=fieldMatcher;
    }

    @Override
    public  Book getBook(Map<Integer, Book> map,String value , Field field) throws NoSuchFieldException {

        if(Book.class.getDeclaredField("title").equals(field)){

            for(Book book:map.values()){
                if(book.getTitle().equals(value)){
                    return book;
                }
            }
        }
        else if(Book.class.getDeclaredField("author").equals(field)){
            for(Book book:map.values()){
                if(book.getAuthor().equals(value)){
                    return book;
                }
            }
        }
        return null;
    }
}
