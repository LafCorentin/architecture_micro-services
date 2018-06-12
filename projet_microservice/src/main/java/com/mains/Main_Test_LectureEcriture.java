package com.mains;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main_Test_LectureEcriture {

	public static int nextInt(FileReader fr) throws IOException  {
		String str = "";
    	int i = 0;
    	while((i = fr.read()) != -1 && ((char)i < '0' || (char)i > '9')) {}
    	str += (char)i;
    	while((i = fr.read()) != -1 && (char)i >= '0' && (char)i <= '9')
    		str += (char)i;
    	return Integer.parseInt(str);
	}
	
	public static void main(String[] args) {      
		File file = new File("test.txt");
	    FileReader fr;
	    try {

	    	
	    	//Création de l'objet de lecture
	    	fr = new FileReader(file);
	    	String str = null;
	    	
	    	while (true) {
	    		str = lireFin(fr);
	    		if (!str.equals(""))
	    			System.out.println(str);

	    	}
	    

	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	  }

	public static String lireFin(FileReader fr) throws IOException {
		String str="";
    	int i;
    	while((i = fr.read()) != -1)
    		str += (char)i;
    	return str;
	}
}