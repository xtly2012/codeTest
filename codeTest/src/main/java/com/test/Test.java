package com.test;

import java.util.ArrayList;
import java.util.List;

public class Test
{
    
    public static void objPoolTest() {
        Integer i1 = 40;
        Integer i2 = 40;
        Integer i3 = 0;
        Integer i4 = new Integer(40);
        Integer i5 = new Integer(40);
        Integer i6 = new Integer(0);
        
        System.out.println("i1=i2\t" + (i1 == i2));
        System.out.println("i1=i2+i3\t" + (i1 == i2 + i3));
        System.out.println("i4=i5\t" + (i4 == i5));
        System.out.println("i4=i5+i6\t" + (i4 == i5 + i6));    
        
        System.out.println(); 
        
    }
    
    public static void main(String[] argus)
    {
//        objPoolTest();
//        
//        String msg = "<ORDERITEM ORDERSEQ=\"M1234567\"/>";
//        System.out.println(msg.indexOf("/>", 1));
//        
//        List<String> list = new ArrayList<String>();
//        list.addAll(new ArrayList<String>());
//        
//        Short sh = 1;
//        
//        Short sh1 = Short.valueOf("1");
//        
//        System.out.println(sh.compareTo(sh1));
//        System.out.println(sh == sh1);
//        
//        
//        System.out.println("sh1 hash code = " +sh1.hashCode());
//        
//        short sh11 = 1;
//        
//        short sh22 = Short.valueOf("1");
//        
//        System.out.println(sh11 == sh22);
//        
//        
//        String str1 = "123";
//        String str2 = new String("123");
//        String str3 = new String("123").intern();
//        
//        System.out.println(str1 == str2);
//        System.out.println(str1 == str3);
//        
//        DecimalFormat format = new DecimalFormat("###.00");
//        System.out.println(format.format(9.999D));
//        
//        short a = 1400;
//        Short b = Short.valueOf("1400");
//        
//        System.out.println(b == a);
//        
//        Short sh = Short.valueOf("1");
//        System.out.println(1 == sh);
//        
//        
//        Date date = new Date(1375179941140L);
//        DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(format.format(date));
//        
//        Boolean b = true;
//        System.out.print(b.equals(true));
//        
//        long temp = 800;
//        System.out.println("temp = " +-temp);
//        System.out.println("temp = " +temp);
//        
//        System.out.println(188115113D/170511);
//        
//        System.out.println(Pattern.matches("\\d*|\\S*", "123abc"));
//        String str = "123";
//        System.out.println(str.matches("^\\d*$"));
//        
//        List<String> list = new ArrayList<String>();
//        list.add("1");
//        list.add("2");
//        list.add("3");
//        list.add("4");
//        list.add("5");
//        
//        for (int i = 0; i < list.size(); i++)
//        {
//           list.remove(i);
//           i--;
//        }
        
        int test = 1;
        Short test1 = 1;
        
        
        System.out.println(test==test1);
    }
    
    public static class Bean
    {
        public String name = null;
    }
}
