package com.chen.http;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HttpClient
{
    private static String urlPath = "http://baidu.lecai.com/lottery/draw/list/50?d=2013-01-01";
    
//    public static String regex = "<tbody>\\s*<tr class=\"bgcolor1\">.*</tr>\\s*</tbody>";
    
    public static String regex = "<tr\\s*class=\"bgcolor1\">\\s*<td\\s*class=\"td1\">[\\d-]*</td>\\s*<td\\s*class=\"td2\">\\s*<a\\s*href=\"[/\\w?=]*\">\\d*</a>\\s*</td>\\s*<td\\s*class=\"td3\">\\s*<span\\s*class=\"result\">[\\s*<span\\s*class=\"\\w*\">\\d*</span>\\s*]*</span>\\s*</td>\\s*<td\\s*class=\"td4\">[\\d,]*</td>\\s*</tr>";
    
    public static void main(String[] argus)
    {
        try
        {            
            URL url = new URL(urlPath);
            HttpURLConnection httpConnect = (HttpURLConnection)url.openConnection();
            httpConnect.setConnectTimeout(10000);
            httpConnect.connect();
            
            BufferedReader reader = new BufferedReader(new InputStreamReader(httpConnect.getInputStream()));
            String lines;
            StringBuffer htmlBuf = new StringBuffer();
            while ((lines = reader.readLine()) != null)
            {
                htmlBuf.append(lines);
            }
            reader.close();
            
            System.out.println(htmlBuf.toString());
            
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(htmlBuf.toString());
            while (matcher.find())
            {
                String matchStr = matcher.group();
                System.out.println(matchStr);
            }
            
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
