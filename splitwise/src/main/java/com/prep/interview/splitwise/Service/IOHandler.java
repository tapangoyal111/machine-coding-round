package com.prep.interview.splitwise.Service;

import java.util.Scanner;

public class IOHandler {

    private static Scanner sc = new Scanner(System.in);
    public static String[] takeInput(int count){
        String[] args=new String[count];
        for(int i=0;i<count;i++){
            args[i]=sc.next();
        }
        return args;
    }

}
