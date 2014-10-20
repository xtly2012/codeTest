package com.aop.cglib.impl;

import com.aop.ForumService;
import com.aop.impl.ForumServiceImpl;


public class TestCglibForumService
{
    public static void main(String[] args)
    {
        CglibProxy proxy = new CglibProxy();
        ForumService impl = (ForumService)proxy.getProxy(ForumServiceImpl.class);
        System.out.println(impl.getClass().toString());
        impl.removeForum(10);
    }
}
