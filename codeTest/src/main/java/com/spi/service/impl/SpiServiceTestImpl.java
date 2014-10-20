package com.spi.service.impl;

import com.spi.service.SpiServiceTest;

public class SpiServiceTestImpl implements SpiServiceTest {

	@Override
	public String search(String keyword) {
		StringBuffer strBuf = new StringBuffer("search data by keyword:");
		strBuf.append(keyword);
		System.out.println(strBuf.toString());
		return strBuf.toString();
	}

}
