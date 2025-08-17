package com.prep.interview.splitwise.exceptions;

import com.prep.interview.splitwise.dto.SplitType;

public class NotValidBalanceSplitterException extends RuntimeException {
    public NotValidBalanceSplitterException(String s, SplitType splitType) {
        super(s +" " +  splitType.toString());
    }
}
