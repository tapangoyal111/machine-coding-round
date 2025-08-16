package com.prep.interview.library_management_system.dto;

import com.prep.interview.library_management_system.Utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.Year;

@Data
public class Book {

    @NonNull
    private int id;
    @NonNull
    private String title;
    @NonNull
    private String author;
    @NonNull
    private Year publishedYear;
    private int totalCopies = Constants.INITIAL_BOOKS_COPIES;
    private int availableCopies = totalCopies;



}
