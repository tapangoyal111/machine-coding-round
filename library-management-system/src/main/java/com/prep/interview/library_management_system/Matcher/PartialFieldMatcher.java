package com.prep.interview.library_management_system.Matcher;

import com.prep.interview.library_management_system.dto.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.Map;

@Service
public class PartialFieldMatcher extends FieldMatcher{


    @Override
    public Book getBook(Map<Integer, Book> map, String value , Field field) throws NoSuchFieldException {
        if(value.length()<3){
            System.out.println("Atleast 3 characters required for partial Match");
        }
        if(Book.class.getDeclaredField("title").equals(field)){
            for(Book book:map.values()){
                if(book.getTitle().startsWith(value)){
                    return book;
                }
            }
        }
        else if(Book.class.getDeclaredField("author").equals(field)){
            for(Book book:map.values()){
                if(book.getAuthor().startsWith(value)){
                    return book;
                }
            }
        }
        return null;
    }

}
