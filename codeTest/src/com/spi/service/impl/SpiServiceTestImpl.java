package com.spi.service.impl;

import com.spi.service.SpiServiceTest;

public class SpiServiceTestImpl implements SpiServiceTest {

	@Override
	public String search(String keyword) {
		StringBuffer strBuf = new StringBuffer("search data by keyword:");
		strBuf.append(keyword);
		return strBuf.toString();
	}

}
