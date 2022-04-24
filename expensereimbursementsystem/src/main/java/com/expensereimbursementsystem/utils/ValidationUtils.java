package com.expensereimbursementsystem.utils;

import java.util.regex.Pattern;

public class ValidationUtils {
	
	private ValidationUtils() {}
	
	private static String emailRegexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@" 
	        + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";
	
	public static boolean patternMatches(String emailAddress) {
	    return Pattern.compile(emailRegexPattern)
	      .matcher(emailAddress)
	      .matches();
	}

}
