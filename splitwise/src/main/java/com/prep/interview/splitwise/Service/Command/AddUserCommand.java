package com.prep.interview.splitwise.Service.Command;

import com.prep.interview.splitwise.Service.IOHandler;
import com.prep.interview.splitwise.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddUserCommand implements InputCommand{

    UserService userService;

    @Autowired
    AddUserCommand(UserService userService){
        this.userService=userService;
    }

    @Override
    public void execute(String[] args) {
        String name = args[0];
        String email=args[1];
        userService.addUser(name,email);
    }

    @Override
    public String[] ioInteraction() {
        System.out.println("Please Enter User Detail in following format\nName Email-id");
        return IOHandler.takeInput(2);


    }
}
