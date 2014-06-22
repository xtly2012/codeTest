package com.test;

public class SubTest extends SupTest
{
    private BaseBean base =null;
    
    public static void main(String[] argus)
    {
        SubTest test = new SubTest();
        test.setBase(new BaseBean());
        System.out.println(test.base);
        System.out.println(test.getBase());
    }
}
