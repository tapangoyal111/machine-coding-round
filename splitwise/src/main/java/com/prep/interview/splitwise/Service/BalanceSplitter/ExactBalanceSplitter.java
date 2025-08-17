package com.prep.interview.splitwise.Service.BalanceSplitter;

import com.prep.interview.splitwise.dto.SplitType;
import com.prep.interview.splitwise.dto.User;
import com.prep.interview.splitwise.dto.UserBalanceOwes;
import com.prep.interview.splitwise.exceptions.NotValidBalanceSplitterException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

@Service
public class ExactBalanceSplitter extends  BalanceSplitter{
    @Override
    public List<UserBalanceOwes> createBalanceOwesList(SplitType splitType, List<Integer> participants, List<Double> amountOwes, double amount) {
        if(splitType.equals(SplitType.EXACT)){
            List<UserBalanceOwes> balanceOwesList = new ArrayList<>();
            for(int i=0;i<participants.size();i++){
                balanceOwesList.add(new UserBalanceOwes(participants.get(i),amountOwes.get(i)));
            }
            return balanceOwesList;
        }
        else{
            throw new NotValidBalanceSplitterException("Not valid Balance Splitter for",splitType);
        }
    }
}
