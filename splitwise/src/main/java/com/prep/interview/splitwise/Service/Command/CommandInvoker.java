package com.prep.interview.splitwise.Service.Command;

import com.prep.interview.splitwise.Service.IOHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CommandInvoker {
    private Map<String,InputCommand> inputCommandMap;

    @Autowired
    CommandInvoker(List<InputCommand> inputCommandList){
        inputCommandMap=new HashMap<>();
        for(InputCommand inputCommand:inputCommandList){
            if(inputCommand instanceof AddUserCommand){
                inputCommandMap.put("ADD_USER",inputCommand);
            } else if (inputCommand instanceof AddExpenseCommand) {
                inputCommandMap.put("ADD_EXPENSE",inputCommand);
            } else if (inputCommand instanceof ShowDebtCommand) {
                inputCommandMap.put("SHOW_DEBT",inputCommand);
            }
        }
    }

    public void runApplication(){
        printBanner();
        while(true){
            System.out.println("\nEnter following command\n" +
                    "1->ADD_USER\n" +
                    "2->ADD_EXPENSE\n" +
                    "3->SHOW_DEBT\n" +
                    "4->EXIT");
            String command= IOHandler.takeInput(1)[0];
            if(command.equals("EXIT")){
                System.out.println("Application has stopped");
                break;
            }
            if(inputCommandMap.containsKey(command)){

                InputCommand inputCommand=inputCommandMap.get(command);
                String[] args=inputCommand.ioInteraction();
                inputCommand.execute(args);
            }else{
                System.out.println("Invalid Command, Please Try again");
            }
        }
    }

    private void printBanner(){
        String message = "Welcome to Splitwise Application!";
        int bannerWidth = message.length() + 6; // Add padding for aesthetic
        for (int i = 0; i < bannerWidth; i++) {
            System.out.print("*");
        }
        System.out.println();
        System.out.println("*  " + message + "  *");
        for (int i = 0; i < bannerWidth; i++) {
            System.out.print("*");
        }
        System.out.println();

    }

}
