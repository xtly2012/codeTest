package com.aop.cglib.impl;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class CglibProxy implements MethodInterceptor
{
    private Enhancer enhancer = new Enhancer();
    
    public Object getProxy(Class<?> clazz)
    {
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return enhancer.create();
    }
    
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable
    {
        System.out.print("method = " +method.getName());
        System.out.println(" argus = " +args[0]);
        Object result = proxy.invokeSuper(obj, args);
        return result;
    }

}
