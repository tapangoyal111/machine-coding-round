package com.prep.interview.splitwise.Repo;

import com.prep.interview.splitwise.Service.IdGenerator.ExpenseIdGenerator;
import com.prep.interview.splitwise.dto.Expense;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ExpenseRepo {
    private Map<Integer, Expense> expenseMap;
    ExpenseRepo(){
        expenseMap=new HashMap<>();
    }
    public void addExpense(Expense expense) {
        expense.setId(ExpenseIdGenerator.generateNextBalanceId());
        expenseMap.put(expense.getId(),expense);
    }
}
