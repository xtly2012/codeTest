package com.chen.security;

public class RSATest
{
    public static void main(String[] argus)
    {
        int p = 61;
        int q = 53;
        int n = p * q;
        
        int f = (p-1) * (q-1);
        int e = 17;
        int d = (f - 1) / e;
        
        // public key (n, e)
        // private key (n, d)
        
        // 加密算法 m^e = c (mod n) public key
        // 解密算法c^d = m (mod n) private key
        
        System.out.println(2753 / d);
    }
}
