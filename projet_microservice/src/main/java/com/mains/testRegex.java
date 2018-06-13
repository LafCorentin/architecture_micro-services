package com.mains;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class testRegex {

	public static void main(String[] args) {
		Pattern pattern;
	    Matcher matcher;
	    pattern = Pattern.compile(".*s.*");
        matcher = pattern.matcher("absolut");
        System.out.println(matcher.find());       
	}

}
