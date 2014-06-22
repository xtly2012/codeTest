package com.huffman;

import java.util.ArrayList;
import java.util.List;

public class HuffmanBean
{
    private String node = null;
    
    private int count = 0;
    
    private String code = "";
    
    private List<HuffmanBean> childNodes = new ArrayList<HuffmanBean>();
    
    public HuffmanBean()
    {
        childNodes = new ArrayList<HuffmanBean>();
    }
    
    public HuffmanBean(String node, int count)
    {
        this.node = node;
        this.count = count;
        childNodes = new ArrayList<HuffmanBean>();
    }

    public String getNode()
    {
        return node;
    }

    public void setNode(String node)
    {
        this.node = node;
    }

    public int getCount()
    {
        return count;
    }

    public void setCount(int count)
    {
        this.count = count;
    }
    
    public void addCount()
    {
        this.count += 1;
    }

    public List<HuffmanBean> getChildNodes()
    {
        return childNodes;
    }

    public void addChildNode(HuffmanBean node)
    {
        this.childNodes.add(node);
    }

    public String getCode()
    {
        return code;
    }

    public void setCode(String code)
    {
        this.code = code;
    }
    
    public void appendCode(String appCode)
    {
        this.code = appCode + this.code; 
    }
}
