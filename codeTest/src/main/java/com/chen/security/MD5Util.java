package com.chen.security;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;



/**
 * @author chen
 */
public class MD5Util
{
    public static final String DEFAULT_CHARSET = "UTF-8";

    private MD5Util()
    {
    }

    static MessageDigest getDigest()
    {
        try
        {
            return MessageDigest.getInstance("MD5");
        }
        catch (NoSuchAlgorithmException e)
        {
            throw new RuntimeException(e);
        }
    }

    public static byte[] md5(byte[] data)
    {
        return getDigest().digest(data);
    }

    public static byte[] md5(String data, String charset) throws UnsupportedEncodingException
    {
        return md5(data.getBytes(charset));
    }

    public static String md5Hex(byte[] data)
    {
        return HexUtil.toHexString(md5(data));
    }

    public static String md5Hex(String data)
    {
        return md5Hex(data, DEFAULT_CHARSET);
    }

    public static String md5Hex(String data, String charset)
    {
        String md5Value = "";
        try
        {
            md5Value = HexUtil.toHexString(md5(data, charset));
        }
        catch (UnsupportedEncodingException e)
        {
            e.printStackTrace();
        }

        return md5Value;
    }

    public static void main(String[] args)
    {
        System.out.println(MD5Util.md5Hex("T20131230198230123127.0.0.1"));
    }
}
