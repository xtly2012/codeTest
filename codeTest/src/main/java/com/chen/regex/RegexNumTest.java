package com.chen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexNumTest {
	
	public static void main(String[] argus) {
		Pattern pattern = Pattern.compile("\\d{10}");
		Matcher matcher = pattern.matcher("BC0001345678");
		
		pattern = Pattern.compile("\\d{10}");
		matcher = pattern.matcher("BC0001345678");
		if (matcher.find()) {
			System.out.println(matcher.group());
		}
	}
}
