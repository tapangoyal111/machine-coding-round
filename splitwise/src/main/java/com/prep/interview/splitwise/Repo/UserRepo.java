package com.prep.interview.splitwise.Repo;

import com.prep.interview.splitwise.Service.IdGenerator.UserIdGenerator;
import com.prep.interview.splitwise.dto.User;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserRepo {

    private Map<Integer, User> userMap;

    UserRepo(){
        userMap=new HashMap<>();
    }

    public void addUser(User user){
        user.setId(UserIdGenerator.getnextUserId());
        userMap.put(user.getId(),user);
    }

    public User getUserById(int id) {
        return userMap.get(id);
    }

}
