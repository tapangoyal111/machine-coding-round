package com.prep.interview.library_management_system.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class IssueId {
    private int memberId;
    private int bookId;
}
