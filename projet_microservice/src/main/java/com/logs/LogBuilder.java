package com.logs;

public class LogBuilder {
	
	public static GeneLog buildLog(final String data, final int n) {
		GeneLog log = null;
		switch(n) {
		case 0:
			log = new logXMLTest(data);
		}
		return log;
	}
}
