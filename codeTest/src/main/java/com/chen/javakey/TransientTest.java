package com.chen.javakey;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TransientTest
{
    public static void main(String[] argus)
    {
        try
        {
            LoggingInfo logInfo = new LoggingInfo("MIKE", "MECHANICS");
            System.out.println(logInfo.toString());
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("d:/logInfo.out"));
            o.writeObject(logInfo);
            o.close();
        }
        catch (Exception e)
        {// deal with exception

        }

        try
        {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream("d:/logInfo.out"));
            LoggingInfo logInfo = (LoggingInfo) in.readObject();
            System.out.println(logInfo.toString());
        }
        catch (Exception e)
        {

        }
    }
}
