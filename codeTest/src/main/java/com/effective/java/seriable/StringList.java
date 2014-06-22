package com.effective.java.seriable;

import java.io.Serializable;

public final class StringList implements Serializable 
{
    
    private int size = 0;
    private Entry head = null;
    
    private static class Entry implements Serializable 
    {
        String data;
        Entry next;
        Entry previous;
    };
    
    public final void add(String s)
    {
        Entry en = new Entry();
        if (head == null)
        {
            head = en;
            return;
        }
        
        Entry temp = head;
        while (temp.next != null)
        {
            temp = temp.next;
        }
        
        temp.next = en;
    }
}
