package com.prep.interview.splitwise.Service.BalanceSplitter;

import com.prep.interview.splitwise.dto.SplitType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BalanceSplitterResolver {

    private Map<SplitType,BalanceSplitter> balanceSplitterMap;

    @Autowired
    BalanceSplitterResolver(List<BalanceSplitter> balanceSplitterList){
        balanceSplitterMap = new HashMap<>();
        for(BalanceSplitter splitter: balanceSplitterList){
            if(splitter instanceof EqualBalanceSplitter){
                balanceSplitterMap.put(SplitType.EQUAL,splitter);
            } else if (splitter instanceof ExactBalanceSplitter) {
                balanceSplitterMap.put(SplitType.EXACT,splitter);
            } else if (splitter instanceof PercentBalanceSplitter) {
                balanceSplitterMap.put(SplitType.PERCENT,splitter);
            }
        }
    }

    public BalanceSplitter getSplitter(SplitType splitType){
        return balanceSplitterMap.get(splitType);
    }

}
