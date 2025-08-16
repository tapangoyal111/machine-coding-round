package com.prep.interview.library_management_system.dto;

import lombok.Data;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Data
public class Member {
    @NonNull
    private int id;
    @NonNull
    private String name;
    private LocalDate membershipDate=LocalDate.now();
    private int overDueCount=0;
    private UserStatus status=UserStatus.ACTIVE;

}
