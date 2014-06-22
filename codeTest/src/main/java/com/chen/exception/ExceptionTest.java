package com.chen.exception;

/**
 * Exception是否受检异常测试类
 * 
 * @project codeTest
 * @module  codeTest
 * @comments
 * @nameSpace com.chen.exception
 * @author chen
 * @since 2014年6月18日
 * @see
 * @modifier
 * @date
 * @version
 */
public class ExceptionTest {
		
	public static void test() throws Exception {
		
	}
	
	public static void main(String[] argus) {
		try {
			test();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	 
}
