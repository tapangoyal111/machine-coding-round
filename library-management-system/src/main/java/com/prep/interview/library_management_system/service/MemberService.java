package com.prep.interview.library_management_system.service;

import com.prep.interview.library_management_system.Generator.MemberIdGenerator;
import com.prep.interview.library_management_system.Repo.MemberRepo;
import com.prep.interview.library_management_system.dto.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    MemberRepo memberRepo;

    @Autowired
    MemberService(MemberRepo memberRepo){
        this.memberRepo=memberRepo;
    }

    public void addMember(String name){
        Member member=new Member(MemberIdGenerator.getId(), name);
        memberRepo.addMember(member);
        System.out.printf("Member added Successfully with id %d\n",member.getId());
    }

    public List<Member> getAllMembers(){
        return memberRepo.findAllMembers();
    }

    public Member getMemberById(int memberId){
        return memberRepo.getMemeberbyId(memberId);
    }

    public void remvoeMember(String name){
        memberRepo.deleteMember(name);
    }

}
