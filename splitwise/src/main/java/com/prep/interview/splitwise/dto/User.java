package com.prep.interview.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
public class User {

    private int id;
    @NonNull
    private String name;
    @NonNull
    private String email;
}
