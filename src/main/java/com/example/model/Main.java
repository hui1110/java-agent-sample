//package com.example.model;
//
//import com.example.factory.JdkProxyFactory;
//import com.example.impl.SmsServiceImpl;
//import com.example.service.SmsService;
//
//
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class Main {
//
//    public static void main(String[] args) throws InstantiationException, IllegalAccessException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException, ClassNotFoundException {
//
////        Class<?> clazz = TargetObject.class;
//        Class<?> clazz = Class.forName("com.example.model.TargetObject");
//        TargetObject targetObject = (TargetObject) clazz.newInstance();
//
//        Method[] methods = clazz.getDeclaredMethods();
//        for (Method method : methods) {
//            System.out.println(method.getName());
//            System.out.println("----------------");
//        }
//
//        Method publicMethod = clazz.getDeclaredMethod("publicMethod", String.class);
//        publicMethod.invoke(targetObject, "161651");
//        System.out.println("----------------");
//
//        Field field = clazz.getDeclaredField("value");
//        field.setAccessible(true);
//        field.set(targetObject, "javaAgent");
//
//        Method privateMethod = clazz.getDeclaredMethod("privateMethod");
//        privateMethod.setAccessible(true);
//        privateMethod.invoke(targetObject);
//
//        System.out.println("......................");
//
//        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
//        smsService.send("java");
//
//        String s = "j,a,v,a";
//        String[] arr = s.split(",");
//        System.out.println(arr.length);
//        System.out.println(arr[0]);
//
//
//        List<Pair<String, Double>> pairArrayList = new ArrayList<>(3);
//        pairArrayList.add(new Pair<>("version", 12.10));
//        pairArrayList.add(new Pair<>("version", 12.19));
//        pairArrayList.add(new Pair<>("version", 6.28));
//        pairArrayList.add(new Pair<>("version", Double.NaN));
//        Map<String, Double> map = pairArrayList.stream().filter(stringDoublePair -> !stringDoublePair.getValue().isNaN()).collect(
//
//                Collectors.toMap(Pair::getKey, Pair::getValue, (v1, v2) -> v2));
//
//        System.out.println(map);
//
//    }
//
//}
