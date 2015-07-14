import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;


public class Test
{
    public static final Map<String,String> map = new HashMap<String,String>();
    
    public static void main(String[] argus)
    {
//        map.put("a", "asdfasdfasdf");
//        System.out.println(map.get("a"));
        
//        System.out.println(String.format("%4s", "12"));
//        String str = "1234";
//        System.out.println(str.replaceAll("\\d", "*"));
//        
//        
//        System.out.println(String.format("%tB", Calendar.getInstance().getTime()));
        
//        System.out.println(String.format("%08d", "12"));
        
//        Date date = new Date(1376134796226L);
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        
//        System.out.println(format.format(date));
        
//        ClassLoader loader = Thread.currentThread().getContextClassLoader();
//        System.out.println("loader is：" +loader);
//        System.out.println("parent loader is：" +loader.getParent());
//        System.out.println("root loader is：" +loader.getParent().getParent());
        
        
//        DateTest test = new DateTest();
//        test.setDate(new Date(1234567));
//        
//        DateTest test1 = test.clone();
//        test1.getDate().setTime(12345678);
//        
//        System.out.println("test = " +test.getDate().getTime());
//        System.out.println("test1 = " +test1.getDate().getTime());
        
//        Date date = new Date();
//        date.setTime(1382101936331L);
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        System.out.println(dateFormat.format(date));
//
//    	Short page = null;
//        short result = (short)page;
    	
//    	String a = "adfasdfasdf";
//    	String b = "adfasdfasdf";
//    	System.out.println(a == b);
//    	DateTest test = new DateTest();
//    	int i = 0;
//    	System.out.println(test.getState() == i);
    	
    	BigDecimal test5 = new BigDecimal("1103.5");
    	System.out.println(test5.setScale(-1,BigDecimal.ROUND_DOWN));
    }
    
    
}

/**
 * @author chenfayong
 *
 */
class DateTest implements Cloneable, Serializable
{

    private static final long serialVersionUID = -860113338612676477L;
    Date date = null;
    Short state = null;

    public Short getState() {
		return state;
	}

	public void setState(Short state) {
		this.state = state;
	}

	public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }
    
    public DateTest clone()
    {
        try
        {
            ByteArrayOutputStream byteOut = new ByteArrayOutputStream();
            ObjectOutputStream objOut = new ObjectOutputStream(byteOut);
            objOut.writeObject(this);
            
            ByteArrayInputStream byteIn = new ByteArrayInputStream(byteOut.toByteArray());
            ObjectInputStream objIn = new ObjectInputStream(byteIn);
            return (DateTest)objIn.readObject();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }
}
