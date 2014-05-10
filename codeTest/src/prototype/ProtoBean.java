package prototype;

import java.util.ArrayList;
import java.util.List;

public class ProtoBean implements Cloneable
{
    private ArrayList<String> list = null;
    
    private String test = null;
    
    public ProtoBean(ArrayList<String> list, String test)
    {
        this.list = list;
        this.test = test;
    }

    public List<String> getList()
    {
        return list;
    }

    public void setList(ArrayList<String> list)
    {
        this.list = list;
    }

    public String getTest()
    {
        return test;
    }

    public void setTest(String test)
    {
        this.test = test;
    }
    
    @Override
    public ProtoBean clone()
    {
        ProtoBean bean = null;
        
        try
        {
            bean = (ProtoBean)super.clone();
            if (bean.list != null)
            {
                bean.list = (ArrayList)this.list.clone();
            }
            
            return bean;
        }
        catch (CloneNotSupportedException e)
        {
            e.printStackTrace();
            return null;
        }
        
    }
    
    public static void main(String[] argus)
    {
        for (String argu : argus)
        {
            System.out.print(",argus = " +argu);
        }
        System.out.println();
        
        ArrayList list = new ArrayList();
        list.add("Hello");
        ProtoBean bean = new ProtoBean(list, "java");
        ProtoBean tbean = bean.clone();
        
        bean.setTest("asdf");
        
        System.out.println("bean.test = " +bean.getTest());
        System.out.println("tbean.test = " +tbean.getTest());
        
        list.clear();
        System.out.println("bean.list = " +bean.getList());
        System.out.println("tbean.test = " +tbean.getList());
        
    }
}
