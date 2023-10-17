package com.example.model;

public class TargetObject {

    private final String value;

    public TargetObject() {
        value = "java";
    }

    public void publicMethod(String s) {
        System.out.println("I love " + s);
    }

    private void privateMethod() {
        System.out.println("value is " + value);
    }

}
