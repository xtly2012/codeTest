package com.spi.service.impl;

import java.util.Iterator;
import java.util.ServiceLoader;

import com.spi.service.SpiServiceTest;

public class SpiMain {
	
	public static void main(String[] argus) {
		ServiceLoader<SpiServiceTest> service = ServiceLoader.load(SpiServiceTest.class);
		Iterator<SpiServiceTest> serIter = service.iterator();
		if (serIter.hasNext()) {
			SpiServiceTest test = serIter.next();
			test.search("test keyword");
		} else {
			System.out.println("not spi service found");
		}
		
	}
}
