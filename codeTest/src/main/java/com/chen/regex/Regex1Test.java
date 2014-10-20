package com.chen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex1Test
{
    public static String src = "aaaaa";// 2009-07-07 04:38:44 127.0.0.1 GET /robots.txt2009-07-07 04:38:44 127.0.0.1 GET /posts/robotfile.txt2009-07-08 04:38:44 127.0.0.1 GET /";
    
    public static String regex = "!(2009-07-07)";
    
    public static void main(String[] argus)
    {
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(src);
        System.out.println(m.group());
        
        System.out.println("end: parse end.");
    }
}
