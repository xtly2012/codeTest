package com.chen.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class LogbackTest
{
    public static void main(String[] argus)
    {
        Logger logger = LoggerFactory.getLogger(LogbackTest.class);
        logger.warn("hello world");
    }
}
