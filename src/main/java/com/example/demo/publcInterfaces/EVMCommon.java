package com.example.demo.publcInterfaces;

import java.util.Set;

public interface EVMCommon {
    String addParticipant(String partyName);
    String removeParticipants(String partyName);
    int UpdateEVM(String partyName);
    int noOfVotes();
}
