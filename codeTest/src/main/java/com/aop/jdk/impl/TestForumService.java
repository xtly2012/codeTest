package com.aop.jdk.impl;

import java.lang.reflect.Proxy;

import com.aop.ForumService;
import com.aop.impl.ForumServiceImpl;

public class TestForumService
{
    public static void main(String[] args)
    {
        ForumService target = new ForumServiceImpl();
        PerformanceHandler handler = new PerformanceHandler(target);
        
        ForumService proxy = (ForumService)Proxy.newProxyInstance(target.getClass().getClassLoader(), 
                target.getClass().getInterfaces(), handler);
        
        System.out.println(proxy);
        proxy.removeForum(10);
        proxy.removeTopic(1012);
    }
}
