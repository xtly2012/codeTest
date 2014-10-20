package com.test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Cat implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private String name;

    public Cat () {

            this.name = "new cat";

    }

    public String getName() {

            return this.name;

    }

    public void setName(String name) {

            this.name = name;

    }

    public static void main(String[] args) {         

            Cat cat = new Cat();

            try {

                    FileOutputStream fos = new FileOutputStream("d:/catDemo.out");

                    ObjectOutputStream oos = new ObjectOutputStream(fos);

                    System.out.println(" 1> " + cat.getName());

                    cat.setName("My Cat");                       

                    oos.writeObject(cat);

                    oos.close();                       

            } catch (Exception ex) {  ex.printStackTrace();   }

            try {

                    FileInputStream fis = new FileInputStream("d:/catDemo.out");

                    ObjectInputStream ois = new ObjectInputStream(fis);

                    cat = (Cat) ois.readObject();

                    System.out.println(" 2> " + cat.getName());

                    ois.close();

            } catch (Exception ex) {

                    ex.printStackTrace();

            }

    }

}
