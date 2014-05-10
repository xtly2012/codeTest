package com.chen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class RegexTest
{
    public static String str = "<tr class=\"bgcolor1\">                        <td class=\"td1\">2012-10-11</td>                        <td class=\"td2\">                                                <a href=\"/lottery/draw/view/50?phase=2012120\">2012120</a>                                                </td>                        <td class=\"td3\"><span class=\"result\">                        <span class=\"ball_1\">01</span>                    <span class=\"ball_1\">04</span>                    <span class=\"ball_1\">20</span>                    <span class=\"ball_1\">24</span>                    <span class=\"ball_1\">28</span>                    <span class=\"ball_1\">29</span>                        <span class=\"ball_2\">16</span>            </span></td>                        <td class=\"td4\">311,866,338</td>                    </tr>   ";
    // <a href=\"/lottery/draw/view/50?phase=2012120\">2012120</a> 
   public static String pattern = "<tr class=\"bgcolor[\\d]1\">.*^(</tr>)</tr>";
//    public static String pattern = "<span class=[\\w\\s\"_]*>[\\w]*</span>";
   
   private static String regexTd1 = "\\s*<td\\s*class=\"td1\">[\\d-]*</td>\\s*";
   private static String regexDate = "[\\d]4-[\\d]2-[\\d]2";
   public static void main(String[] argus)
   {
       String trStr = " <tr class=\"bgcolor1\">                        <td class=\"td1\">2013-09-05</td>                        <td class=\"td2\">                                                <a href=\"/lottery/draw/view/50?phase=2013104\">2013104</a>                                                </td>                        <td class=\"td3\"><span class=\"result\">                        <span class=\"ball_1\">01</span>                    <span class=\"ball_1\">02</span>                    <span class=\"ball_1\">04</span>                    <span class=\"ball_1\">15</span>                    <span class=\"ball_1\">17</span>                    <span class=\"ball_1\">28</span>                        <span class=\"ball_2\">11</span>            </span></td>                        <td class=\"td4\">339,771,188</td>                    </tr>   ";
       try
       {
           Pattern td1Pattern = Pattern.compile(regexTd1);
           Matcher td1Matcher = td1Pattern.matcher(trStr);
           td1Matcher.find();
           String str = td1Matcher.group();
           Pattern datePattern = Pattern.compile(regexDate);
           Matcher dateMatcher = datePattern.matcher(str);
           if (dateMatcher.find())
           {
               System.out.println(dateMatcher.group());
           }
           System.out.println(td1Matcher.group());
//           LotteryTicket lottery = this.lotteryDataService.parseTr2Bean(trStr);
//           System.out.println(lottery);
       }
       catch (Exception e)
       {
           e.printStackTrace();
       }
   }
   
//    public static void main(String[] argus)
//    {
//        // 检测完全匹配
//        // "Str".matches("Regex") is equal with Pattern.matches("Regex", "Str")
////        System.out.println("Match All: " + Pattern.matches("^([a-z]*//s)*$", str));
////        System.out.println("Match All: " + str.matches("^([a-z]*//s)*$"));
//        Pattern p = Pattern.compile(pattern);
//        Matcher m = p.matcher(str);
//        // 检索匹配部分
//        while (m.find())
//        {
//            System.out.println(m.group());
//        }
//    }

}
