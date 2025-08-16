package com.prep.interview.library_management_system.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookReturnCoordinator {

    BookReturnService bookReturnService;
    BookOverDueService bookOverDueService;

    @Autowired
    BookReturnCoordinator(BookReturnService bookReturnService, BookOverDueService bookOverDueService){
        this.bookReturnService=bookReturnService;
        this.bookOverDueService = bookOverDueService;
    }

    public void returnAndCalculate(int bookId,int memberId){

        double fine = bookOverDueService.calculateBookOverDueCharge(bookReturnService.returnBook(bookId,memberId));
        System.out.printf("Fine for this return is %f\n",fine);

    }



}
