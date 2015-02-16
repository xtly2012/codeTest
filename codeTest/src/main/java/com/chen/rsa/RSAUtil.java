package com.chen.rsa;

public class RSAUtil {
	/**
	 * 素数1
	 */
	private static long p = 0;
	
	/**
	 * 素数2
	 */
	private static long q = 0;
	
	/**
	 * n = p * q
	 */
	private static long n;
	
	/**
	 * fn = (p-1) * (q-1)
	 */
	private static long fn = 0;
	
	/**
	 * e与fn互质，且1 < e < fn
	 */
	private static long e = 0;
	
	/**
	 * e * d ≡ 1 mod fn
	 */
	private static long d = 0;
	
	
	private static void init() {
		p = 3;
		q = 11;
		n = p * q;
		fn = (p - 1) * (q - 1);
		e = 3;
		d = 7;
	}
	
	/**
	 * (M)d%n
	 * @param input
	 * @return
	 */
	public static long encrypt(long input) {
		return ((long)Math.pow(input, d)) % n;
	}
	
	/**
	 * (C)e%n
	 * @param input
	 * @return
	 */
	public static long decrypt(long input) {
		return ((long)Math.pow(input, e)) % n;
	}
	
	public static void main(String[] argus) {
			RSAUtil.init();
			
			long M = 17;
			long C = RSAUtil.encrypt(M);
			System.out.println("C = " +C);
			M = RSAUtil.decrypt(C);
			System.out.println("M = " +M);
	}
}
