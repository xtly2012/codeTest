package com.test.serialize;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerialVersionTest
{
    
    public static void main(String[] argus)
    {
        try
        {
//            writeObject();
            readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
    
    
    public static void readObject()
    {
        Address address;
        
        try{
  
            FileInputStream fin = new FileInputStream("d:\\address.ser");
            ObjectInputStream ois = new ObjectInputStream(fin);
            address = (Address) ois.readObject();
            ois.close();
  
            System.out.println(address);
  
        }catch(Exception ex){
            ex.printStackTrace(); 
        } 
    }
    
    public static void writeObject()
    {
        Address address = new Address();
        address.setStreet("wall street");
        address.setCountry("united states");
  
        try{
  
         FileOutputStream fout = new FileOutputStream("d:\\address.ser");
         ObjectOutputStream oos = new ObjectOutputStream(fout);   
         oos.writeObject(address);
         oos.close();
         System.out.println("Done");
  
        }catch(Exception ex){
            ex.printStackTrace();
        } 
    }
}
