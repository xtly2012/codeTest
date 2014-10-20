package com.aop.jdk.impl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class PerformanceHandler implements InvocationHandler
{
    private Object target;
    
    public PerformanceHandler(Object target)
    {
        this.target = target;
    }
    
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable
    {
        System.out.println("start time is " +System.currentTimeMillis());
        Object obj = method.invoke(target, args);
        System.out.println("start time is" +System.currentTimeMillis());
        return obj;
    }

}
