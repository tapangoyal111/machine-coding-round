package com.prep.interview.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserBalanceOwes {
    private int userId;
    private double balanceOwes;
}
