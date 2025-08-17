package com.prep.interview.splitwise;

import com.prep.interview.splitwise.Service.BalanceOwesService;
import com.prep.interview.splitwise.Service.DebtDisplayService.DebtDisplayService;
import com.prep.interview.splitwise.Service.DebtDisplayService.NormalDebtDisplayService;
import com.prep.interview.splitwise.Service.ExpenseService;
import com.prep.interview.splitwise.Service.UserService;
import com.prep.interview.splitwise.dto.Expense;
import com.prep.interview.splitwise.dto.SplitType;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class SplitwiseApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SplitwiseApplication.class, args);
		UserService userService = context.getBean(UserService.class);
		ExpenseService expenseService = context.getBean(ExpenseService.class);
		BalanceOwesService balanceOwesService = context.getBean(BalanceOwesService.class);
		DebtDisplayService displayService = context.getBean(NormalDebtDisplayService.class);

		Scanner sc = new Scanner(System.in);

//		Creating banner
		String message = "Welcome to Splitwise Application!";
		int bannerWidth = message.length() + 6; // Add padding for aesthetic
		for (int i = 0; i < bannerWidth; i++) {
			System.out.print("*");
		}
		System.out.println();
		System.out.println("*  " + message + "  *");
		for (int i = 0; i < bannerWidth; i++) {
			System.out.print("*");
		}
		System.out.println();
		boolean isRunning=true;

		while(isRunning){
			System.out.println("\nEnter following key\n1->Add User\n2->Add Expense\n3->Show All Expenses\n4->Show Any user Expense\n5->Exit");
			int command = sc.nextInt();
			switch (command){
				case 1:{
//					adding user
					System.out.println("Please Enter User Detail in following format\nName Email-id");
					String name = sc.next();
					String email=sc.next();
					userService.addUser(name,email);
					break;
				}
				case 2:{
//					adding Expenses
					System.out.println("Please Enter the Expense Detail in following format\nPayer-id Amount-Paid Description Number-of-total-participants-including-you SplitType(EQUAL,PERCENT,EXACT)");
					int payerId=sc.nextInt();
					double amount=sc.nextDouble();
					String description=sc.next();
					int totalCount=sc.nextInt();
					SplitType splitType=SplitType.valueOf(sc.next());
					List<Integer> userIdList=new ArrayList<>();
					List<Double> distributionList=new ArrayList<>();

					if(!splitType.equals(SplitType.EQUAL)){
						System.out.println("You have selected "+ splitType + " SplitType.Please add details in following format\n" +
								"userId distribution " + (splitType.equals(SplitType.PERCENT)?"in %":" in Rupees"));

						for(int i=0;i<totalCount;i++){
							userIdList.add(sc.nextInt());
							distributionList.add(sc.nextDouble());
						}
					}
					else{
						System.out.println("You have selected "+ splitType + " SplitType.Please add details in following format\n" +
								"userId");

						for(int i=0;i<totalCount;i++){
							userIdList.add(sc.nextInt());
						}
					}
					expenseService.addExpense(new Expense(payerId,amount,splitType,description,userIdList,distributionList));
					break;
				}
				case 3:{
					displayService.showAllDebt();
					break;
				}
				case 4:{
					System.out.println("Please add details in following format\nUser-id");
					displayService.showDebtForUser(sc.nextInt());
					break;
				}
				case 5:{
					isRunning=false;
					break;
				}
				default:{
					System.out.println("Not a valid operation!!\n Try Again");
				}
			}
		}
	}


}
