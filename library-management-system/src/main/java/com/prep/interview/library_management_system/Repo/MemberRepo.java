package com.prep.interview.library_management_system.Repo;

import com.prep.interview.library_management_system.Generator.MemberIdGenerator;
import com.prep.interview.library_management_system.dto.Member;
import org.springframework.stereotype.Indexed;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MemberRepo {

    private static Map<Integer, Member> memberMap = new HashMap<>();

    public void addMember(Member member){
        memberMap.put(member.getId(),member);
    }

    public List<Member> findAllMembers() {
        return  memberMap.values().stream().toList();
    }

    public Member getMemeberbyId(int id){
        return memberMap.get(id);
    }

    public void deleteMember(String name) {
        for(Member member:memberMap.values()){
            if(member.getName().equals(name)){
                memberMap.remove(member);
                return;
            }
        }
        System.out.println("There are no members with this name.\n !! Can't remove this one");
    }


}
