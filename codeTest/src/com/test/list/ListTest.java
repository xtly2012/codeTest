package com.test.list;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ListTest
{
    public static void main(String[] argus)
    {
        List<String> list = new ArrayList<String>();
        
        list.add(null);
        list.add(null);
        System.out.println(list.size());
    }
}
