package com.chen.virtualmachine;

public class JavaVMStackSOF {
	
	private int stackLength = 1;
	
	public void stackLeak() {
		stackLength++;
		stackLeak();
	}
	
	public static void main(String[] args) throws Throwable {
		JavaVMStackSOF oom = new JavaVMStackSOF();
		try {
			oom.stackLeak();
			System.out.println("program is close.");
		} catch(Throwable e) {
			System.out.println("stack length:" +oom.stackLength);
			e.printStackTrace();
		}
	}
}
