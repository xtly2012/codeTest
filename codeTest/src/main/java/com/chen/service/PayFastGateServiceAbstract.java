package com.chen.service;

import java.io.UnsupportedEncodingException;
import java.util.Map;

public abstract class PayFastGateServiceAbstract<T extends SignUserBO> implements PayFastGateService<T>
{

    protected static String fromUTF82GBK(String str) throws UnsupportedEncodingException
    {
        if (str == null)
        {
            return null;
        }
        
        return new String(str.getBytes("UTF-8"),"GBK"); 
    }

    /**
     * 获Map中value数组中的第一个值,如果值为空字符串则返回null
     * @param dataMap - Map对象
     * @param key - 关键字
     * @return - 值
     */
    protected static String getMapFirstValue(Map<String, String[]> dataMap, String key)
    {
        if (dataMap == null)
        {
            return null;
        }
        
        String[] valArr = dataMap.get(key);
        if (valArr == null || valArr.length == 0)
        {
            return null;
        }
        
        if (valArr[0].trim().isEmpty())
        {
            return null;
        }
        
        return valArr[0];
    }
    
    protected static String getXmlValue(String xmlStr, String startLabel, String endLabel) {
        if (startLabel == null || endLabel == null || xmlStr == null) 
        {
            return null;
        }
        
        if (xmlStr.indexOf(startLabel) < 0 || xmlStr.indexOf(endLabel) < 0 || xmlStr.indexOf(startLabel) > xmlStr.indexOf(endLabel))
        {
            return null;
        }
        
        String result = xmlStr.substring(xmlStr.indexOf(startLabel) +startLabel.length(), xmlStr.indexOf(endLabel));
        if (result == null || result.trim().isEmpty())
        {
            return null;
        }
        
        return result;
    }

}
