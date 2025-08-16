package com.prep.interview.library_management_system;

import com.prep.interview.library_management_system.Repo.BookIssueRepo;
import com.prep.interview.library_management_system.service.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import java.time.Year;
import java.util.Scanner;

@SpringBootApplication
public class LibraryManagementSystemApplication {

	public static void main(String[] args) {
		ApplicationContext context= SpringApplication.run(LibraryManagementSystemApplication.class, args);

		BookIssueService bookIssueService=context.getBean(BookIssueService.class);
		BookReturnCoordinator bookReturnCoordinator=context.getBean(BookReturnCoordinator.class);
		BookService bookService=context.getBean(BookService.class);
		MemberService memberService=context.getBean(MemberService.class);
		BookOverDueService bookOverDueService=context.getBean(BookOverDueService.class);

		Scanner sc=new Scanner(System.in);
		System.out.println("Welcome to Library Management");

		while(true){
			System.out.println("Please enter the request");
			String command= sc.next();
			switch (command){
				case "AddBook" : {
					String bookName= sc.next();
					String author = sc.next();
					int year = sc.nextInt();
					bookService.addBookToLib(bookName,author, Year.of(year));
					break;
				}
				case "AddMember" : {
					String memberName = sc.next();
					memberService.addMember(memberName);
					break;
				}
				case "BorrowBook" :{
					int memberId = sc.nextInt();
					int bookId = sc.nextInt();
					bookIssueService.borrowBook(bookId,memberId);
					break;

				}
				case "ListOverdueBooks" : {
					bookOverDueService.listOverDueBooks();
					break;

				}
				case "ReturnBook" : {
					int memberId = sc.nextInt();
					int bookId = sc.nextInt();
					bookReturnCoordinator.returnAndCalculate(bookId,memberId);
					break;
				}
				default:{
					System.out.println("We don't support current operation at the moment");
				}
			}
		}
	}

}
