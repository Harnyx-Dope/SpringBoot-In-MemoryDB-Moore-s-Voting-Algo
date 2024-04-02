package com.example.demo.publcInterfaces;

import java.util.Map;

public interface EVMPollResults {
    Map<String,Integer> currentSuccessor();
    String Winner();
    int  MooreCalcbyMajority();

}
