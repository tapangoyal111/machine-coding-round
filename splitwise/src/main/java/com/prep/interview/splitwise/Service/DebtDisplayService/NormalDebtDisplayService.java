package com.prep.interview.splitwise.Service.DebtDisplayService;

import com.prep.interview.splitwise.Service.BalanceOwesService;
import com.prep.interview.splitwise.dto.OweSummaryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NormalDebtDisplayService implements DebtDisplayService{

    BalanceOwesService balanceOwesService;

    @Autowired
    NormalDebtDisplayService(BalanceOwesService balanceOwesService){
        this.balanceOwesService=balanceOwesService;
    }

    @Override
    public void showAllDebt() {
        List<OweSummaryResponse> balanceOwesList=balanceOwesService.getBalancesforAllUsers();
        balanceOwesList.forEach(System.out::println);
    }

    @Override
    public void showDebtForUser(int userId) {
        List<OweSummaryResponse> balanceOwesList=balanceOwesService.getBalancesforUserId(userId);
        balanceOwesList.forEach(System.out::println);
    }
}
