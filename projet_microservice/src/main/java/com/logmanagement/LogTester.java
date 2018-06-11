package com.logmanagement;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import com.logs.GeneLog;

public class LogTester {

	protected ConditionOnLog condt;
	
	protected final String cheminParam;
	
	public boolean testLog(GeneLog log) {
		return condt.tester(log);
	}
	
	public void majCond() {
		DataInputStream dis;
		int res = -1;
		try {
			dis = new DataInputStream(
					new FileInputStream(
						new File(cheminParam)));
			dis.readFloat(); // la periode
			res = dis.readInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
		}
		
		switch (res) {
		
		// TODO raccrocher ici la généraation des conditions
		
		// TODO rajouter aussi le cas ou on ne change que les paramètres et où l'on ne recréé pas la classe

		default:
			condt = new ConditionTrue();
		}
	}
	
	public LogTester(String chemin) {
		cheminParam = chemin;
		majCond();
	}

	public Collection<GeneLog> filtrerLogs(Collection<GeneLog> nvLogs) {
		GeneLog res = null;
		for (Iterator<GeneLog> it = nvLogs.iterator(); it.hasNext(); res = it.next())
			if (res != null && !condt.tester(res))
				it.remove();
		return nvLogs;
	}
	
}
