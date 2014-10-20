package com.test;

import java.util.ArrayList;
import java.util.List;

public class FSMTest
{
    public static String[] V = {"a", "b", "c", "A", "B", "C", "S"}; 
    
    public static String[] T = {"a", "b", "c"};
    
    public static String[][] P = {
        {"S", "AB"}, 
        {"A", "Ca"}, 
//        {"B", "Ba"},
        {"B", "aC"},
        {"B", "Cb"},
        {"B", "b"},
        {"C", "cb"},
        {"C", "b"}};
    
    public static void main(String[] argus)
    {
        String start = "S";
        
        List<String> dataList = new ArrayList<String>();
        dataList.add(start);
        for (int k = 0; k < dataList.size(); k++)
        {
            start = dataList.get(k);
            System.out.println(start);
            System.out.println("list size = " +dataList.size());
            for (int i = 0; i < start.length(); i++)
            {
                List<String> resultList = next(start.substring(i, i+1));
                for (int j = 0; j < resultList.size(); j++)
                {
                    if (i < start.length())
                    {
                        dataList.add(start.substring(0, i) +resultList.get(j) +start.substring(i+1));
                    }
                    else
                    {
                        dataList.add(start.substring(0, i) +resultList.get(j));
                    }
                }
            }
        }
        
        for (int i = 0, j = dataList.size(); i < j; i++)
        {
            System.out.println(dataList.get(i));
        }
    }
    
    public static List<String> next(String str)
    {
        if (str == null)
        {
            return null;
        }
        
        List<String> strList = new ArrayList<String>();
        for (int i = 0, j = P.length; i < j; i++)
        {
            if (str.equals(P[i][0]))
            {
                strList.add(P[i][1]);
            }
        }
        
        return strList;
    }
}
