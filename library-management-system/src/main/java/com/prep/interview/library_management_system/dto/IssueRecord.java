package com.prep.interview.library_management_system.dto;

import com.prep.interview.library_management_system.Utils.Constants;
import lombok.Data;
import lombok.NonNull;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

@Data
public class IssueRecord {
    @NonNull
    private IssueId issueId;
    private LocalDate borrowDate=LocalDate.now();
    private LocalDate dueDate = LocalDate.now().plus(Constants.DUE_DATE_DURATION, ChronoUnit.DAYS);
    private LocalDate returnedDate;
    private IssueRecordStatus status= IssueRecordStatus.BORROWED;
}
