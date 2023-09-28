package com.example.controller;

import com.sun.tools.attach.VirtualMachine;
import com.sun.tools.attach.VirtualMachineDescriptor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AttachController {

    @RequestMapping(value = "/attach", method = RequestMethod.GET)
    public String updateClassMethod(){
        try {

            List<VirtualMachineDescriptor> list = VirtualMachine.list();
            for (VirtualMachineDescriptor vmd : list) {
                if (vmd.displayName().equals("com.example.AgentDemoApplication")) {
                    VirtualMachine virtualMachine = VirtualMachine.attach(vmd.id());
                    virtualMachine.loadAgent("C:\\item\\java-agent-sample\\target\\java-agent-sample-0.0.1-SNAPSHOT.jar");
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
