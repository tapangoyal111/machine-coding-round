package com.prep.interview.splitwise.Service;

import com.prep.interview.splitwise.dto.BalanceOwes;
import com.prep.interview.splitwise.dto.OweSummaryResponse;
import com.prep.interview.splitwise.dto.UserBalanceOwes;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public class BalanceOwesService {

    private Map<Integer, Map<Integer,Double>> balanceSheet;

    BalanceOwesService(){
        this.balanceSheet=new HashMap<>();
    }

    public void addBalance(BalanceOwes balanceOwes) {
        int payerId = balanceOwes.getUserId();
        if(!balanceSheet.containsKey(payerId)){
            balanceSheet.put(payerId,new HashMap<>());
        }
        updateExistingBalance(balanceOwes);
        System.out.println("Balance Added Successfully");
    }
    private void updateExistingBalance(BalanceOwes balanceOwes) {
        int payerId=balanceOwes.getUserId();

        for(UserBalanceOwes eachBalance: balanceOwes.getBalanceOwesList()){
            int receiverId=eachBalance.getUserId();
            if(payerId<receiverId){
                Map<Integer ,Double> currentMap=balanceSheet.get(payerId);
                Double existingBalace=currentMap.get(receiverId);
                currentMap.put(receiverId, (existingBalace!=null?existingBalace : 0 ) + eachBalance.getBalanceOwes());
            }
            else if(payerId>receiverId){
                if(!balanceSheet.containsKey(receiverId)){
                    balanceSheet.put(receiverId,new HashMap<>());
                }
                Map<Integer ,Double> currentMap=balanceSheet.get(receiverId);
                Double existingBalace=currentMap.get(payerId);
                currentMap.put(payerId, (existingBalace!=null?existingBalace : 0 ) - eachBalance.getBalanceOwes());
            }
        }
    }
    public List<OweSummaryResponse> getBalancesforUserId(int userId){
        List<OweSummaryResponse> oweSummaryResponses = new ArrayList<>();
        Map<Integer,Double>  owesByUserId = balanceSheet.get(userId);
        if(owesByUserId!=null)
        owesByUserId.forEach((k,v)->oweSummaryResponses.add(new OweSummaryResponse(userId,k,v)));
        balanceSheet.entrySet().forEach((k)->{
            if(k.getKey()<userId){
                Double value  = k.getValue().get(userId);
                if(value!=null){
                    oweSummaryResponses.add(new OweSummaryResponse(k.getKey(),userId,value));
                }
            }
        });
        return oweSummaryResponses;
    }

    public List<OweSummaryResponse> getBalancesforAllUsers(){
        List<OweSummaryResponse> oweSummaryResponses = new ArrayList<>();

        balanceSheet.entrySet().forEach((k)->{
            k.getValue().forEach((key,val)->{
                oweSummaryResponses.add(new OweSummaryResponse(k.getKey(),key,val));
            });
        });
        return oweSummaryResponses;
    }
}
