package com.example.demo.service;

import com.example.demo.publcInterfaces.EVMPollResults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EVMPollServices implements EVMPollResults
{
    @Autowired
    EVMService evm ;
    @Override
    public Map<String, Integer> currentSuccessor() {
        // To find the current Successor but this approach will take time and will not work live lively;
        HashMap<String,Integer> hh= (HashMap) evm.getParticipanmts();
        int max=Integer.MIN_VALUE;

        Map<String, Integer> CurrSucc=new WeakHashMap<>();


        for (Map.Entry<String, Integer> participants : hh.entrySet()) {
            int value = participants.getValue();


            if (value > max) {
                max = value;
            }
        }
        for (Map.Entry<String, Integer> participants : hh.entrySet()) {
            if (max ==participants.getValue()) {
                CurrSucc.put(participants.getKey(), max);
            }
        }
        return CurrSucc;
    }

    public int  MooreCalcbyMajority() {
        List<Integer> votes=evm.getLiveList();
        int partyIdx = -1;
        int count = 0;

        for (int vote : votes) {
            if (count == 0) {
                partyIdx = vote;
                count = 1;
            } else if (vote == partyIdx) {
                count++;
            } else {
                count--;
            }
        }

        return partyIdx;
    }

    @Override
    public String Winner() {
        String winner="";
        HashMap<String,Integer> hh= (HashMap) evm.getParticipanmts();
        int max=Integer.MIN_VALUE;




        for (Map.Entry<String, Integer> participants : hh.entrySet()) {
            int value = participants.getValue();


            if (value > max) {
                max = value;
            }
        }
        for (Map.Entry<String, Integer> participants : hh.entrySet()) {
            if (max ==participants.getValue()) {
                winner=participants.getKey();
            }
        }
        return winner;
    }
}
