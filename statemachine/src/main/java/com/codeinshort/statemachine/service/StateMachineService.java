package com.codeinshort.statemachine.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.state.State;
import org.springframework.stereotype.Service;

@Service
public class StateMachineService {

    @Autowired
    private StateMachine<String, String> stateMachine;

    public void startMachine(){
        stateMachine.start();
        stateMachine.sendEvent("E1");
        System.out.println("Initial State: " + stateMachine.getInitialState().getId());
    }
}
