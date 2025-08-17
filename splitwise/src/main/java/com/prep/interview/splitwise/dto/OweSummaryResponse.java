package com.prep.interview.splitwise.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@AllArgsConstructor
public class OweSummaryResponse {

    int user1;
    int user2;
    double amount;

    @Override
    public String toString(){
        if(amount<0){
            return "User with id "+ user1 +" owes amount "+ Math.abs(amount) + " to User with id "+ user2;
        }else if(amount>0){
            return "User with id "+ user2 +" owes amount "+ amount + " to User with id "+ user1;
        }else{
            return "";
        }

    }

}
