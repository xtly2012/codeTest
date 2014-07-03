package com.escape;

import java.util.StringTokenizer;

/**
 * Created by chen on 2014/7/3.
 */
public class EscapeTest {

    public static void main(String[] argus) {
        String dataResult = "06005014070300778683|06005|10.0|20140703|103351|0|E2014070300778683|E2014070300778683";
        String[] dataArr = dataResult.split("\\|");
        System.out.println("data = " +dataArr[0]);
        System.out.println("|".getBytes());
        System.out.println("\\|".getBytes());
        
        System.out.println("a".getBytes());
        System.out.println("\\a".getBytes());

//        StringTokenizer stringTokenizer = new StringTokenizer(dataResult, "|");
//        while (stringTokenizer.hasMoreElements()) {
//            System.out.println(stringTokenizer.nextElement());
//        }
    }
}
