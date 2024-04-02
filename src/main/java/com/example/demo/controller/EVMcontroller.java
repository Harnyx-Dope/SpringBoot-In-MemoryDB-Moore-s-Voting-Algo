package com.example.demo.controller;

import com.example.demo.service.EVMPollServices;
import com.example.demo.service.EVMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/EVM/Entry/")
public class EVMcontroller
{
    @Autowired
    EVMService evm;
    @Autowired
    EVMPollServices evm1;


    @GetMapping("/addParticipants")
    public String addParticipants(@RequestBody String s)
    {
        return evm.addParticipant(s);
    }
    @GetMapping("/noOfVotes")
    public int Votescount()
    {
        return evm.noOfVotes();
    }
    @GetMapping("/LiveVotingList")
    public List<Integer> LiveList()
    {
        return   evm.getLiveList();
    }
    @GetMapping("/Winner")
    public String Winner()
    {
        return   evm1.Winner();
    }
    @GetMapping("/Successor")
    public String Successor()
    {
        return evm1.currentSuccessor().toString();
    }
    @GetMapping("/Majority")
    public  int calcMajority()
    {
        return evm1.MooreCalcbyMajority();
    }


    @GetMapping("/removeParticipants")
    public String removeParticipants(@RequestBody String s)
    {
        return evm.removeParticipants(s);
    }
    @GetMapping("/addVote")
    public String addVote(@RequestBody String s)
    {
        if(evm.UpdateEVM(s)==1)
        {
            return "Vote Added";
        }else {
            return "Party Not in the List!!! Vote Again";
        }

    }
    @GetMapping("/allParticipants")
    public Map<String,Integer> addParticipants()
    {
        return evm.allParticipant();
    }
}
