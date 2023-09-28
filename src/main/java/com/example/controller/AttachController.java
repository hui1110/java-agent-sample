package com.example.controller;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttachController {
    private static final String AGENT_PATH = "C:\\item\\java-agent-sample\\target\\java-agent-sample-0.0.1-SNAPSHOT.jar";
    private static final String AGENT_ARGS = "com.example.AgentDemoApplication";

    @RequestMapping(value = "/attach", method = RequestMethod.GET)
    public String updateClassMethod(){
        try {

            List<VirtualMachineDescriptor> list = VirtualMachine.list();
            for (VirtualMachineDescriptor vmd : list) {
                if (vmd.displayName().equals(AGENT_ARGS)) {
                    VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                    virtualMachine.loadAgent(AGENT_PATH);
                    virtualMachine.detach();
                }
            }
        } catch (Exception e) {
            System.out.println("attach failed, error: " + e.getMessage());
            return "attach failed";
        }
        return "attach success";
    }

}
