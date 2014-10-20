package com.util.test;

public class HashMapTest
{
    public static void main(String[] argus)
    {
        int h = -123;
        int temp = h>>3;
        System.out.println(temp);
        System.out.println(Integer.toBinaryString(temp)); // “>> 右移,高位补符号位” 这里右移一位表示除2
        h = -123;
        temp = h>>>3;
        System.out.println(temp);
        System.out.println(Integer.toBinaryString(temp)); // “>>> 无符号右移,高位补0”； 与>>类似
        
        String hashTest = "abc";
    }
}
