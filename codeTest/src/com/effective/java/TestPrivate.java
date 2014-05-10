package com.effective.java;

public class TestPrivate
{
    private String name;
    
    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    private TestPrivate(String name)
    {
        this.name = name;
    }
    
    protected static TestPrivate getInstance(String name)
    {
        return new TestPrivate(name);
    }
    
    
    public static void main(String[] argus)
    {
        TestPrivate test = getInstance("test");
        System.out.println(test.getName());
    }
}
