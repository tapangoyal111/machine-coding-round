package com.prep.interview.splitwise.Service.Command;

import com.prep.interview.splitwise.Service.ExpenseService;
import com.prep.interview.splitwise.Service.IOHandler;
import com.prep.interview.splitwise.dto.Expense;
import com.prep.interview.splitwise.dto.SplitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AddExpenseCommand implements InputCommand{
    ExpenseService expenseService;

    @Autowired
    AddExpenseCommand(ExpenseService expenseService){
        this.expenseService=expenseService;
    }

    @Override
    public void execute(String[] args) {
        int payerId=Integer.parseInt(args[0]);
        double amount=Double.parseDouble(args[1]);
        String description=args[2];
        int totalCount=Integer.parseInt(args[3]);;
        SplitType splitType=SplitType.valueOf(args[4]);
        List<Integer> userIdList=new ArrayList<>();
        List<Double> distributionList=new ArrayList<>();

        if(!splitType.equals(SplitType.EQUAL)){

            for(int i=0;i<totalCount;i++){
                userIdList.add(Integer.parseInt(args[5+ (2*i)]));
                distributionList.add(Double.parseDouble(args[6 + (2*i)]));
            }
        }
        else {

            for (int i = 0; i < totalCount; i++) {
                userIdList.add(Integer.parseInt(args[5 + i]));
            }
        }
        expenseService.addExpense(new Expense(payerId,amount,splitType,description,userIdList,distributionList));

    }

    @Override
    public String[] ioInteraction() {
        System.out.println("Please Enter the Expense Detail in following format\nPayer-id Amount-Paid Description Number-of-total-participants-including-you SplitType(EQUAL,PERCENT,EXACT)");
        String args[] = IOHandler.takeInput(5);
        int index=0;
        if(args[4].equals(SplitType.EQUAL.toString())){
            System.out.println("Please add details in following format\n" +
                    "userId");
            String[] userLists= IOHandler.takeInput(Integer.parseInt(args[3]));
            String[] finalArgs=new String[5+Integer.parseInt(args[3])];
            for(String a:args){
                finalArgs[index++]=a;
            }
            for(String a:userLists){
                finalArgs[index++]=a;
            }
            return finalArgs;

        }else if(args[4].equals(SplitType.PERCENT.toString()) || args[4].equals(SplitType.EXACT.toString())){
            System.out.println("Please add details in following format\n" +
                    "userId distribution");
            String[] userLists= IOHandler.takeInput(2*Integer.parseInt(args[3]));
            String[] finalArgs=new String[5+2*Integer.parseInt(args[3])];
            for(String a:args){
                finalArgs[index++]=a;
            }
            for(String a:userLists){
                finalArgs[index++]=a;
            }
            return finalArgs;

        }
        else{
            System.out.println("Please enter correct SplitType");
            return null;
        }
    }
}
