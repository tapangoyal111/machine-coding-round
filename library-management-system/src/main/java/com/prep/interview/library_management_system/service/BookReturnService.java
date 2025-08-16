package com.prep.interview.library_management_system.service;

import com.prep.interview.library_management_system.Repo.BookIssueRepo;
import com.prep.interview.library_management_system.Repo.BookRepo;
import com.prep.interview.library_management_system.dto.Book;
import com.prep.interview.library_management_system.dto.IssueId;
import com.prep.interview.library_management_system.dto.IssueRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class BookReturnService {

    BookIssueRepo bookIssueRepo;

    BookService bookService;

    @Autowired
    public BookReturnService(BookIssueRepo bookIssueRepo, BookService bookService){
        this.bookService=bookService;
        this.bookIssueRepo=bookIssueRepo;
    }

    public IssueRecord returnBook(int bookId, int memberId) {
        IssueRecord record = bookIssueRepo.returnBook(new IssueId(bookId, memberId));
        if (record != null) {
            Book book = bookService.findBookById(bookId);
            book.setAvailableCopies(book.getAvailableCopies() + 1);
        }else{
            System.out.println("No Book Issued with this BookId and MemberId");
        }
        return record;
    }
}
