package com.prep.interview.library_management_system.service;

import com.prep.interview.library_management_system.Repo.BookRepo;
import com.prep.interview.library_management_system.Repo.BookIssueRepo;
import com.prep.interview.library_management_system.Repo.MemberRepo;
import com.prep.interview.library_management_system.Utils.Constants;
import com.prep.interview.library_management_system.dto.Book;
import com.prep.interview.library_management_system.dto.IssueId;
import com.prep.interview.library_management_system.dto.IssueRecord;
import com.prep.interview.library_management_system.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookIssueService {


    BookService bookService;

    MemberService memberService;

    BookIssueRepo bookIssueRepo;

    @Autowired
    public BookIssueService(BookService bookService, MemberService memberService, BookIssueRepo bookIssueRepo){
        this.bookService=bookService;
        this.memberService=memberService;
        this.bookIssueRepo = bookIssueRepo;
    }

    public void borrowBook(int bookId , int memberId){
        if(bookValidator(bookId) && memberValidator(memberId)){
            IssueId issueId =  new IssueId(bookId,memberId);
            IssueRecord issueRecord = new IssueRecord(issueId);
            System.out.println("Book Issues successfully");
            System.out.println("Due date for this Book is "+ bookIssueRepo.createBorrowRecord(issueRecord).toString());
            Book book = bookService.findBookById(bookId);
            book.setAvailableCopies(book.getAvailableCopies()-1);
        }
        else{
            System.out.println("Book can't be issued");
        }
    }

    private boolean bookValidator(int bookId){
        Book book= bookService.findBookById(bookId);
        return (book!=null && book.getAvailableCopies()>0);
    }

    private boolean memberValidator(int memberId){
        Member member = memberService.getMemberById(memberId);
        return (member!=null && bookIssueRepo.getActiveRecordByMemberId(memberId)< Constants.MAX_BOOKS_ALLOWED_PER_USER);
    }


}
