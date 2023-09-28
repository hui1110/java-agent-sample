package com.example.agent;

import com.example.transformer.AgentTransformer;

import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;

public class AgentMainAgent {
    private static final String AGENT_CONTROLLER = "com.example.controller.HelloController";

    public static void agentmain(String agentArgs, Instrumentation inst)
            throws ClassNotFoundException, UnmodifiableClassException {
        inst.addTransformer(new AgentTransformer(), true);
        inst.retransformClasses(Class.forName(AGENT_CONTROLLER,
                false, ClassLoader.getSystemClassLoader()));
    }

}
