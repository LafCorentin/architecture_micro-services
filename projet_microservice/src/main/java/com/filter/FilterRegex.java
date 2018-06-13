package com.filter;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.logs.GeneLog;

public class FilterRegex extends AbstractFilter {

	private static Pattern pattern;
    private static Matcher matcher;
    protected String param;

    public FilterRegex(String param) {
		this.param = param;
	}

    public String getParam() {
    	return param;
    }
    
    public void setParam(String param) {
    	this.param = param;
    }
    
	public static int count(String element, String cible) {
        pattern = Pattern.compile(element);
        matcher = pattern.matcher(cible);
        int res = 0;
        while(matcher.find()) 
        	res++;
        return res;
    }
	
	public static boolean isIn(String element, String cible) {
        pattern = Pattern.compile(element);
        matcher = pattern.matcher(cible);
        return matcher.find();
    }
	
	@Override
	public boolean tester(GeneLog log) {
		return isIn(param, log.getData());
	}

}
