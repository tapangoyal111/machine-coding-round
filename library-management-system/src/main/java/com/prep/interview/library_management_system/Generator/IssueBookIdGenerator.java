package com.prep.interview.library_management_system.Generator;

import com.prep.interview.library_management_system.dto.IssueId;
import org.springframework.stereotype.Service;

@Service
public class IssueBookIdGenerator {

    private static IssueId getIssueId(int bookId, int memberId){
        return new IssueId(bookId,memberId);
    }

}
