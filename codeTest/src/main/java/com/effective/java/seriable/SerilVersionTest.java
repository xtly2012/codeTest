package com.effective.java.seriable;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerilVersionTest
{
    private static int length = 10000; 
    public static void main(String[] argus)
    {
        long startTime = System.currentTimeMillis();
        Period[] perArr = new Period[length];
        for (int i = 0; i < length; i++)
        {
            perArr[i] = new Period(new Date(), new Date());
        }
        long endTime = System.currentTimeMillis();
        
        System.out.println("time is " +(endTime - startTime));
        
        try
        {
            long sum = 0;
            FileOutputStream fout = new FileOutputStream("d:\\period.ser");
            ObjectOutputStream oos = new ObjectOutputStream(fout);
            for (int i = 0; i < 100; i++)
            {
                sum += writeObject(perArr, oos);
            }
            oos.close();
            System.out.println("average time is " + sum / 100);
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public static long writeObject(Period[] perArr, ObjectOutputStream oos)
    {
        try
        {
            
            
            long startTime = System.currentTimeMillis();
            for (int i = 0; i < perArr.length; i++)
            {
                oos.writeObject(perArr[i]);
            }
            long endTime = System.currentTimeMillis();
            
            return endTime - startTime;
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
            return 0;
        }
        
    }
}
