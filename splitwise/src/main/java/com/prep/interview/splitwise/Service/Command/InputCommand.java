package com.prep.interview.splitwise.Service.Command;

public interface InputCommand {

    public void execute(String[] args);

    public String[] ioInteraction();
}
