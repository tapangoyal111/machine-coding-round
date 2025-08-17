package com.prep.interview.splitwise.Service.Command;

import com.prep.interview.splitwise.Service.DebtDisplayService.DebtDisplayService;
import com.prep.interview.splitwise.Service.IOHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShowDebtCommand implements InputCommand{

    DebtDisplayService displayService;

    @Autowired
    ShowDebtCommand(DebtDisplayService displayService){
        this.displayService=displayService;
    }

    @Override
    public void execute(String[] args) {
        int userId=Integer.parseInt(args[0]);
        if(userId==0){
            displayService.showAllDebt();
        }
        else{
            displayService.showDebtForUser(userId);
        }
    }

    @Override
    public String[] ioInteraction() {
        System.out.println("Please add details in following format\nUser-id\n(0 in case of all debt-summary)");
        return IOHandler.takeInput(1);
    }
}
