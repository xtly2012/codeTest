package com.huffman;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class HuffmanTest
{
    
    public static void main(String[] argus)
    {
        String text = "that that that is that that is not is that that is that that is is not true is not true ttttttttttttttttttt";
        
        Character ch = null;
        HuffmanBean bean = null;
        StringBuilder strBuilder = new StringBuilder(text);
        HashMap<Character,HuffmanBean> map = new HashMap<Character,HuffmanBean>();
        for (int i = 0, j = strBuilder.length(); i < j; i++)
        {
            ch = strBuilder.charAt(i);
            bean = map.get(ch);
            if (bean != null)
            {
                bean.addCount();
                map.put(ch, bean);
            }
            else
            {
                bean = new HuffmanBean(String.valueOf(ch), 1);
                map.put(ch, bean);
            }
        }
        
        Set<Entry<Character,HuffmanBean>> set = map.entrySet();
        Iterator<Entry<Character,HuffmanBean>> iter = set.iterator();
        List<HuffmanBean> dataList = new ArrayList<HuffmanBean>();
        while (iter.hasNext())
        {
            dataList.add(iter.next().getValue());
        }
        
        HuffmanBean min1 = null;
        HuffmanBean min2 = null;
        HuffmanBean temp = null;
        while (true)
        {
            for (int i = 0; i < dataList.size(); i++)
            {
                temp = dataList.get(i);
                if (min2 != null && temp != min1 && temp.getCount() < min2.getCount() )
                {
                    min2 = temp;
                }
                else if (min2 == null && temp != min1)
                {
                    min2 = temp;
                }
                
                if (min1 != null && min2.getCount() < min1.getCount())
                {
                    if (dataList.size() == 2)
                    {
                        temp = min1;
                        min1 = min2;
                        min2 = temp;
                    }
                    else
                    {
                        min1 = min2;
                        min2 = null;
                    }
                }
                else if (min1 == null)
                {
                    min1 = min2;
                    min2 = null;
                }
            }
            
            if (min1 != null && min2 == null)
            {
                break;
            }
            
            dataList.remove(min1);
            dataList.remove(min2);
            
            appendCode(min1, "0");
            appendCode(min2, "1");
            
            HuffmanBean manBean = new HuffmanBean();
            manBean.setCount(min1.getCount() + min2.getCount());
            manBean.addChildNode(min1);
            manBean.addChildNode(min2);
            dataList.add(manBean);
            min1 = null;
            min2 = null;
        }
        
        printf(dataList.get(0));
    }
    
    public static void printf(HuffmanBean manBean)
    {
        List<HuffmanBean> dataList = manBean.getChildNodes();
        if (dataList.size() > 0)
        {
            for (int i = 0; i < dataList.size(); i++)
            {
                printf(dataList.get(i));
            }
        }
        
        if (manBean.getNode() != null)
        {
            System.out.println("node = " +manBean.getNode() +",code=" +manBean.getCode() +",count=" +manBean.getCount());
        }
    }
    
    
    public static void appendCode(HuffmanBean manBean,String appCode)
    {
        List<HuffmanBean> dataList = manBean.getChildNodes();
        if (dataList.size() > 0)
        {
            for (int i = 0; i < dataList.size(); i++)
            {
                appendCode(dataList.get(i), appCode);
            }
        }
        if (manBean.getNode() != null)
        {
            manBean.appendCode(appCode);
        }
    }
}
