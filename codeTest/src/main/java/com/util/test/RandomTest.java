package com.util.test;

import java.util.Random;


public class RandomTest
{
    public static void main(String[] argus)
    {
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < 5; i++)
            System.out.println(random.nextInt(20));
        
        System.out.println(random.getClass().getClassLoader());
        System.out.println(Thread.currentThread().getContextClassLoader());
    }
}
