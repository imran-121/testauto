package com.testauto.core;
import java.io.StringWriter;

/*
 * Below class is responsible for handling generic tasks 
 * 
 */
public class Helpers {
	// In below function we are converting exception object to string so that we can log info in file
	public static String convertExcepToStr(Exception e)
	{	
		StringWriter sw = new StringWriter();
		String stackTrace = sw.toString(); // stack trace as a string
		return stackTrace;
	}
}
