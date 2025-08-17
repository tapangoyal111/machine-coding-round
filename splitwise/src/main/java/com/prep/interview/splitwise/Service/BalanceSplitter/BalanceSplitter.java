package com.prep.interview.splitwise.Service.BalanceSplitter;

import com.prep.interview.splitwise.dto.SplitType;
import com.prep.interview.splitwise.dto.User;
import com.prep.interview.splitwise.dto.UserBalanceOwes;

import java.util.List;
import java.util.PriorityQueue;

public abstract class BalanceSplitter {

    public abstract List<UserBalanceOwes> createBalanceOwesList(SplitType splitType, List<Integer> participants, List<Double> amountOwes, double amount);
}