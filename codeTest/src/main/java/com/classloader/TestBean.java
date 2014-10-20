package com.classloader;

public class TestBean
{
    public TestBean()
    {
        System.out.println("TestBean is loaded by " + this.getClass().getClassLoader());
    }
}
