package com.prep.interview.library_management_system.Repo;

import com.prep.interview.library_management_system.dto.IssueId;
import com.prep.interview.library_management_system.dto.IssueRecord;
import com.prep.interview.library_management_system.dto.IssueRecordStatus;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BookIssueRepo {

    private static Map<IssueId, IssueRecord> borrowingRecordMap= new HashMap<>();

    public LocalDate createBorrowRecord(IssueRecord issueRecord) {
        borrowingRecordMap.put(issueRecord.getIssueId(), issueRecord);
        return issueRecord.getDueDate();
    }

    public int getActiveRecordByMemberId(int memberId){
        int cnt=0;
        for(Map.Entry<IssueId, IssueRecord> entry: borrowingRecordMap.entrySet()){
            if(entry.getKey().getMemberId()==memberId){
                if(entry.getValue().getStatus()== IssueRecordStatus.BORROWED){
                    cnt++;
                }
            }

        }
        return  cnt;
    }


    public IssueRecord returnBook(IssueId issueId) {
        IssueRecord record = borrowingRecordMap.get(issueId);
        if(record!=null) {
            record.setStatus(IssueRecordStatus.RETURNED);
            record.setReturnedDate(LocalDate.now());
        }
        return record;
    }

    public List<IssueRecord> getAllOverDueRecords() {
        return borrowingRecordMap.values().stream()
                .filter(r->r.getStatus()==IssueRecordStatus.BORROWED
                        && LocalDate.now().isAfter(r.getDueDate()))
                .collect(Collectors.toList());
    }
}
