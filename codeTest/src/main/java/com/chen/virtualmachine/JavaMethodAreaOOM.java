package com.chen.virtualmachine;

import java.lang.reflect.Method;

import com.chen.virtualmachine.HeapOOM.OOMObject;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

public class JavaMethodAreaOOM {
	
	public static void main(String[] args) {
		while (true) {
			Enhancer enhancer = new Enhancer();
			enhancer.setSuperclass(OOMObject.class);
			enhancer.setUseCache(false);
			enhancer.setCallback(new MethodInterceptor() {

				@Override
                public Object intercept(Object obj, Method method,
                        Object[] args, MethodProxy proxy) throws Throwable {
	                // TODO Auto-generated method stub
	                return proxy.invokeSuper(obj, args);
                }
				
			});
			enhancer.create();
		}
	}
}
