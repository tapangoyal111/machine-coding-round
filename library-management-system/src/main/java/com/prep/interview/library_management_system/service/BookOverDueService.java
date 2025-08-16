package com.prep.interview.library_management_system.service;

import com.prep.interview.library_management_system.Repo.BookIssueRepo;
import com.prep.interview.library_management_system.Utils.Constants;
import com.prep.interview.library_management_system.dto.IssueRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookOverDueService {

    BookIssueRepo bookIssueRepo;

    @Autowired
    BookOverDueService(BookIssueRepo repo){
        this.bookIssueRepo=repo;
    }

    public double calculateBookOverDueCharge(IssueRecord record){
        double fine=0;
        if(record!=null){
            fine= Math.max(record.getReturnedDate().compareTo(record.getDueDate()),0)* Constants.FINE_PER_EXTRA_DAY;
        }
        return fine;
    }

    public void listOverDueBooks(){
        List<IssueRecord> recordList = bookIssueRepo.getAllOverDueRecords();
        if(recordList.isEmpty()){
            System.out.println("No overdue books");
            return;
        }
        recordList.forEach(System.out::println);
    }

}
