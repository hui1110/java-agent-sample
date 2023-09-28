package com.example.agent;

import com.example.transformer.AgentTransformer;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMainAgent {

    public static void agentmain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException {
        inst.addTransformer(new AgentTransformer(), true);
        inst.retransformClasses(Class.forName("com.example.controller.HelloController",
                false, ClassLoader.getSystemClassLoader()));
    }

}
