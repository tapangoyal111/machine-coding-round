package com.prep.interview.splitwise.Service;

import com.prep.interview.splitwise.Repo.ExpenseRepo;
import com.prep.interview.splitwise.Service.BalanceSplitter.BalanceSplitterResolver;
import com.prep.interview.splitwise.dto.BalanceOwes;
import com.prep.interview.splitwise.dto.Expense;
import com.prep.interview.splitwise.dto.UserBalanceOwes;
import com.prep.interview.splitwise.exceptions.InvalidExpenseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    BalanceSplitterResolver balanceSplitterResolver;

    BalanceOwesService balanceOwesService;

    ExpenseRepo expenseRepo;

    @Autowired
    ExpenseService(BalanceSplitterResolver balanceSplitterResolver,BalanceOwesService balanceOwesService,ExpenseRepo expenseRepo){
        this.balanceSplitterResolver=balanceSplitterResolver;
        this.balanceOwesService=balanceOwesService;
        this.expenseRepo=expenseRepo;
    }

    public void addExpense(Expense expense){
        if(expense.isValid()){
            List<UserBalanceOwes> balanceOwesList = balanceSplitterResolver.getSplitter(expense.getSplitType()).createBalanceOwesList(expense.getSplitType(),expense.getUsers(),expense.getSplits(),expense.getAmount());
            expenseRepo.addExpense(expense);
            balanceOwesService.addBalance(new BalanceOwes(expense.getPayerId(),balanceOwesList));
        }
        else{
            throw new InvalidExpenseException("Expense is not valid");
        }
    }

}
