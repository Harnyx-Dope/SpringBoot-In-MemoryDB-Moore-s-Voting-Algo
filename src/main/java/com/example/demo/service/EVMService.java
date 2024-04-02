package com.example.demo.service;

import com.example.demo.publcInterfaces.EVMCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EVMService implements EVMCommon
{

    public int ctr;
    EVMService()
    {
        ctr=0;
    }
    public Map<String, Integer> getParticipanmts() {
        return participanmts;
    }


    private Map<String,Integer> participanmts=new HashMap<>();

    public List<Integer> getLiveList() {
        return LiveList;
    }

    private List<Integer> LiveList=new ArrayList<>();



    @Override
    public String addParticipant(String partyName) {
        String s;
        if(!participanmts.containsKey(partyName))
        {
            participanmts.put(partyName,0);

            s="Added";
        }
        else {
            s="Already there !!! Hold On Baby!!";
        }

        return s;
    }
    public Map<String,Integer > allParticipant() {
        return participanmts;

    }
    @Override
    public int noOfVotes()
    {
        return ctr;
    }

    @Override
    public String removeParticipants(String partyName) {
        String s;
        if(participanmts.containsKey(partyName))
        {
           participanmts.remove(partyName);
           s="removed";
        }else
        {
            s="Not There !! Check your data";
        }
        return s;

    }

    @Override
    public int UpdateEVM(String partyName) {
        int n=0;
        if(participanmts.containsKey(partyName))
        {
            ctr++;
            participanmts.put(partyName, participanmts.get(partyName)+1);

            int index = -1;
            int currentIndex = 0;

            for (Map.Entry<String, Integer> entry : participanmts.entrySet()) {
                if (entry.getKey().equals(partyName) ){
                    index = currentIndex;
                    break;
                }
                currentIndex++;
            }
            LiveList.add(index);
            n=1;
        }
        else {
            n=-1;
        }
        return n;
    }


    @Override
    public String toString() {
        return "EVMService{" +
                "participanmts=" + participanmts +
                '}';
    }
}
