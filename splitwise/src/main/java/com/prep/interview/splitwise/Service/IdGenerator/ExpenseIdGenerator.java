package com.prep.interview.splitwise.Service.IdGenerator;

public class ExpenseIdGenerator {
    private static int currentBalanceId=1;

    public static int generateNextBalanceId(){
        return currentBalanceId++;
    }
}
