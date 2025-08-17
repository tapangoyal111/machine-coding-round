package com.prep.interview.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.PriorityQueue;

@Data
@AllArgsConstructor
public class BalanceOwes {

    private int userId;
    private List<UserBalanceOwes> balanceOwesList;

}
