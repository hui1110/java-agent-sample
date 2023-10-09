package com.example.transformer;

import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtMethod;

import java.lang.instrument.ClassFileTransformer;
import java.security.ProtectionDomain;

public class AgentTransformer implements ClassFileTransformer {

    private static final String TARGET_CLASS_NAME = "com.example.controller.HelloController";
    private static final String TARGET_METHOD_NAME = "origin";
    private static final String TARGET_CLASS_NAME2 = "com.azure.spring.controller.Index";
    private static final String TARGET_METHOD_NAME2 = "index";

    @Override
    public byte[] transform(ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) {
        try {
            className = className.replace("/", ".");
//            System.out.println("Load Class: " + className);
            if (TARGET_CLASS_NAME.equals(className)) {
                System.out.println("Find target class: " + className);
                CtClass ctclass = ClassPool.getDefault().get(className);
                updateMethodContent(ctclass, TARGET_METHOD_NAME);
                agentMethod(ctclass);
                return ctclass.toBytecode();
            } else if(TARGET_CLASS_NAME2.equals(className)){
                System.out.println("Find target class: " + className);
                CtClass ctclass = ClassPool.getDefault().get(className);
                updateMethodContent(ctclass, TARGET_METHOD_NAME2);
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


    public static void main(String[] args) {
        int a = 4992;
        System.out.println(Integer.toBinaryString(a));
        a>>=10;
        System.out.println(a);
        System.out.println(Integer.toBinaryString(a));
    }
}
