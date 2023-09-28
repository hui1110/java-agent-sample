package com.example.agent;

import com.example.transformer.AgentTransformer;

import java.lang.instrument.Instrumentation;

public class PreMainAgent {

    public static void premain(String args, Instrumentation ins) {
        System.out.printf("Pre-Main called , args : " + args);
        ins.addTransformer(new AgentTransformer(), true);
    }

}
