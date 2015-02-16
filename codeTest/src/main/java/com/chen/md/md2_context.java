package com.chen.md;

public class md2_context {
	public char[] cksum = new char[16]; /*!< checksum of the data block */
	public char[] state = new char[48]; /*!< intermediate digest state */
	public char[] buffer = new char[16]; /*!< data block being processed */

	public char[] ipad = new char[64]; /*!< HMAC: inner padding */
	public char[] opad = new char[64]; /*!< HMAC: outer padding */
	public int left; /*!< amount of data in buffer */
}
