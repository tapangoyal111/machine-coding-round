package com.prep.interview.library_management_system.Matcher;

import com.prep.interview.library_management_system.dto.Book;

import java.lang.reflect.Field;
import java.util.Map;

public abstract class FieldMatcher {

    FieldMatcher nextFieldMatcher;

    public Book findBook(Map<Integer, Book> map,String value , Field field) throws NoSuchFieldException {

        Book book=getBook(map,value,field);
        if(book!=null){
            return book;
        }
        else if(nextFieldMatcher !=null){
            return nextFieldMatcher.getBook(map,value,field);
        }
        else{
            return null;
        }
    }

    public abstract Book getBook(Map<Integer, Book> map,String value , Field field) throws NoSuchFieldException;




}
