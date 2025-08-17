package com.prep.interview.splitwise.Service;

import com.prep.interview.splitwise.Repo.UserRepo;
import com.prep.interview.splitwise.dto.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    UserRepo userRepo;

    @Autowired
    UserService(UserRepo userRepo){
        this.userRepo=userRepo;
    }

    public void addUser(String name,String email){
        User user=new User(name,email);
        userRepo.addUser(user);
        System.out.printf("User added successfully with id %d\n",user.getId());
    }

    public User findUserById(int id){
        return userRepo.getUserById(id);
    }

}
