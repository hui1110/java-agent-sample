package com.example.transformer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class AgentTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        try {
            className = className.replace("/", ".");
//            System.out.println("Load Class: " + className);
            if ("com.example.controller.HelloController".equals(className)) {
                System.out.println("Find target class: " + className);
                CtClass ctclass = ClassPool.getDefault().get(className);
                updateMethodContent(ctclass, "origin");
                agentMethod(ctclass);
                return ctclass.toBytecode();
            } else if("com.azure.spring.controller.Index".equals(className)){
                System.out.println("Find target class: " + className);
                CtClass ctclass = ClassPool.getDefault().get(className);
                updateMethodContent(ctclass, "index");
                agentMethod(ctclass);
                return ctclass.toBytecode();
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    private static void updateMethodContent(CtClass ctClass, String methodName) {
        try {
            CtMethod mainMethod = ctClass.getDeclaredMethod(methodName);
            String bodyStr = "{\n" + "return \"hello world【version2】\";" + "}";
            mainMethod.setBody(bodyStr);
            ctClass.detach();
            System.out.println("Content changes: " + mainMethod.getName());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private static void agentMethod(CtClass ctClass) {
        try {
//            CtField startTime = new CtField(CtClass.intType, "startTime", ctClass);
//            ctClass.addField(startTime);
//            CtField endTime = new CtField(CtClass.intType, "endTime", ctClass);
//            ctClass.addField(endTime);

//            ERROR: class redefinition failed: attempted to change the schema (add/remove fields)

            CtMethod[] methods = ctClass.getDeclaredMethods();

            for (CtMethod methodName : methods) {
                CtMethod ctmethod = ctClass.getDeclaredMethod(methodName.getName());
                ctmethod.addLocalVariable("startTime", CtClass.longType);
                ctmethod.addLocalVariable("endTime", CtClass.longType);
                ctmethod.insertBefore("startTime = System.currentTimeMillis();");
                String endSrc = "endTime = System.currentTimeMillis();";
                endSrc += "System.out.println(\"The method <" + ctmethod.getName() + "> cost time: \"+(endTime-startTime)+\"ms\");";
                ctmethod.insertAfter(endSrc);
                System.out.println("Instrumented method: " + ctmethod.getName());
                System.out.println("-------------------------------------------");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
