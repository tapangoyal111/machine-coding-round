package com.prep.interview.splitwise.Service.IdGenerator;


public class UserIdGenerator {

    private static int currentUserId=1001;

    public static int getnextUserId(){
        return  currentUserId++;
    }

}
