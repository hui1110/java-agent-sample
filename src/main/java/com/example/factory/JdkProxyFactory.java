package com.example.factory;

import com.example.handler.DebugInvocationHandler;

import java.lang.reflect.Proxy;

public class JdkProxyFactory {
    public static Object getProxy(Object target) {

        return Proxy.newProxyInstance(
            target.getClass().getClassLoader(),
            target.getClass().getInterfaces(),
            new DebugInvocationHandler(target)
        );
    }

}
