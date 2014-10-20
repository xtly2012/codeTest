package com.effective.java.seriable;

import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;

public class Period implements Serializable
{


    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    private final Date start;
    
    private final Date end;
    
    public Period(Date start, Date end)
    {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        
        if (this.start.compareTo(this.end) > 0)
        {
            throw new IllegalArgumentException(start +"after" +end);
        }
    }
    
    public Date start()
    {
        return new Date(this.start.getTime());
    }
    
    public Date end()
    {
        return new Date(this.end.getTime());
    }
    
    public String toString()
    {
        return this.start +" - " +this.end;
    }
    
    
    public static void main(String[] argus)
    {
        Period p = new Period(Calendar.getInstance().getTime(), new Date(System.currentTimeMillis() + 1000));
        System.out.println(p);
    }
}
