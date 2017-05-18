package com.ayyll.util;

public class PythonUtils {

	public static void excuteQSBKSpider() throws Exception {
		System.out.println("开始爬取糗事百科...");
		Process proc = Runtime.getRuntime().exec("python qsbk.py");    
	}
}
