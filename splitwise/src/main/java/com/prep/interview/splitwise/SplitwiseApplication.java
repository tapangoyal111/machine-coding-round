package com.prep.interview.splitwise;

import com.prep.interview.splitwise.Service.BalanceOwesService;
import com.prep.interview.splitwise.Service.Command.CommandInvoker;
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
		CommandInvoker commandInvoker=context.getBean(CommandInvoker.class);
		commandInvoker.runApplication();
	}
}
