package com.prep.interview.splitwise.Service.BalanceSplitter;

import com.prep.interview.splitwise.dto.SplitType;
import com.prep.interview.splitwise.dto.User;
import com.prep.interview.splitwise.dto.UserBalanceOwes;
import com.prep.interview.splitwise.exceptions.NotValidBalanceSplitterException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EqualBalanceSplitter extends BalanceSplitter{

    @Override
    public List<UserBalanceOwes> createBalanceOwesList(SplitType splitType, List<Integer> participants, List<Double> amountOwes, double amount) {
        if(splitType.equals(SplitType.EQUAL)){
            List<UserBalanceOwes> balanceOwesList = new ArrayList<>();
            double amountOwesEach = amount/(participants.size() );
            participants.forEach(p->balanceOwesList.add(new UserBalanceOwes(p,amountOwesEach)));
            return balanceOwesList;
        }
        else{
            throw new NotValidBalanceSplitterException("Not valid Splitter for:",splitType);
        }
    }

}
