package com.prep.interview.splitwise.dto;

import com.prep.interview.splitwise.Service.IdGenerator.ExpenseIdGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class Expense {
    private int id ;
    @NonNull
    private int payerId;
    @NonNull
    private double amount;
    @NonNull
    private SplitType splitType;
    @NonNull

    private String description;
    @NonNull
    private List<Integer> users;
    @NonNull
    private List<Double> splits;

    public boolean isValid(){
        if(amount<=0) return false;
        if(users.isEmpty()) return false;
        if (SplitType.PERCENT == splitType) {
            return users.size()==splits.size() && splits.stream().mapToDouble(Double::doubleValue).sum()==100;

        }
        else if(SplitType.EXACT == splitType){
            return  users.size()==splits.size() && splits.stream().mapToDouble(Double::doubleValue).sum()==amount;
        }
        return true;
    }

}
