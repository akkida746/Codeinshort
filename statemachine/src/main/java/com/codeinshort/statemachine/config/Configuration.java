package com.codeinshort.statemachine.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnableStateMachine;
import org.springframework.statemachine.config.StateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import java.util.Arrays;
import java.util.HashSet;

@org.springframework.context.annotation.Configuration
@EnableStateMachine
public class Configuration extends StateMachineConfigurerAdapter<String, String> {

    @Bean
    public Action<String, String> initAction(){
        return ctx -> System.out.println("Init action executed on:" + ctx.getTarget().getId());
    }

    @Override
    public void configure(StateMachineStateConfigurer<String, String> states)
            throws Exception {

        states.withStates()
                .initial("SI")
                .end("SF")
                .states(new HashSet<String>(Arrays.asList("S1", "S2", "S3")));
    }

    @Override
    public void configure(
            StateMachineTransitionConfigurer<String, String> transitions)
            throws Exception {

        transitions.withExternal()
                .source("SI").target("S1").event("E1").action(initAction()).and()
                .withExternal()
                .source("S1").target("S2").event("E2").and()
                .withExternal()
                .source("S2").target("SF").event("end");
    }
}
