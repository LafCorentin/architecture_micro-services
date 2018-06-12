package com.divers;

import java.io.FileReader;
import java.io.IOException;

public class LectEcrPerso {
	
	public static int nextInt(FileReader fr) throws IOException  {
		String str = "";
    	int i = 0;
    	while((i = fr.read()) != -1 && ((char)i < '0' || (char)i > '9')) {}
    	str += (char)i;
    	while((i = fr.read()) != -1 && (char)i >= '0' && (char)i <= '9')
    		str += (char)i;
    	return Integer.parseInt(str);
	}
	
	public static String lireFin(FileReader fr) throws IOException {
		String str="";
    	int i;
    	while((i = fr.read()) != -1)
    		str += (char)i;
    	return str;
	}

	public static boolean visible(final String res) {
		for (int i = 0; i < res.length(); i++)
			if (!" \n\t\b".contains("" + res.charAt(i)))
				return false;
		return true;
	}
}
