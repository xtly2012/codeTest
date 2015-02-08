package com.chen.analyzer;

import java.io.IOException;  
import java.io.StringReader;  
import org.apache.lucene.analysis.Analyzer;  
import org.apache.lucene.analysis.TokenStream;  
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;  
import org.wltea.analyzer.lucene.IKAnalyzer;  

public class IKAnalyzerTest {
	 public static void main(String[] args) throws IOException {  
	        String text="基于java语言开发的轻量级的中文分词工具包";  
	        //创建分词对象  
	        Analyzer anal=new IKAnalyzer(true);       
	        StringReader reader=new StringReader(text);  
	        //分词  
	        TokenStream ts=anal.tokenStream("", reader);  
	        CharTermAttribute term=ts.getAttribute(CharTermAttribute.class);  
	        //遍历分词数据  
	        while(ts.incrementToken()){  
	            System.out.print(term.toString()+"|");  
	        }  
	        reader.close();  
	        System.out.println();  
	    }  
}
