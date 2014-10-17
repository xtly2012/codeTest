package com.chen.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexEnvTest {

	public static final Pattern EL_PATTERN = Pattern.compile("\\$\\{[^\\$\\{]*\\}");

	public static void main(String[] argus) {
		String path = "${JAVA_HOME}asdfasdf${JAVA_HOME}dsfwfda${JAVA_HOME}";
		String pathCopy = path;
		try {
			Matcher matcher = EL_PATTERN.matcher(path);
			while (matcher.find()) {
				String el = matcher.group();
				String envKey = el.substring(2, el.length() - 1);
				System.out.println("envKey = " + envKey);
				String envValue = System.getenv(envKey);
				if (envValue != null && !envValue.trim().isEmpty()) {
					String regex = "${" + envKey + "}";
					path = path.replace(regex, envValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			path = pathCopy;
		}
		
		System.out.println(path);
	}
}
