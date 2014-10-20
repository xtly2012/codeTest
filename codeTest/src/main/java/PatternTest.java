import java.util.regex.Matcher; 
import java.util.regex.Pattern; 

public class PatternTest { 
    
    static String str = "four dog lag pad fat for rat mad map car "; 
    static String pattern = "//b//w*(?=o)//w*//b"; 
    
    public static void main(String[] args) { 
        // 检测完全匹配 
        // "Str".matches("Regex") is equal with Pattern.matches("Regex", "Str") 
//        System.out.println("Match All: " + Pattern.matches("^([a-z]*//s)*$", str)); 
//        System.out.println("Match All: " + str.matches("^([a-z]*//s)*$")); 
//        Pattern p = Pattern.compile(pattern); 
//        Matcher m = p.matcher(str); 
//        // 检索匹配部分 
//        while (m.find()) { 
//            System.out.println(m.group()); 
//        } 
//        
//        Pattern pa = Pattern.compile("[\u4E00-\u9FA5]+");
//        Matcher ma = pa.matcher("中国asdfasdf你好");
//        System.out.println("ma.find = " +ma.find());
//        System.out.println("ma.group = " +ma.group());
//        System.out.println("ma.find = " +ma.find());
//        System.out.println("ma.group = " +ma.group());
        
        
        System.out.println("1234asdf".matches("\\d*[a-z]+"));
    }
}