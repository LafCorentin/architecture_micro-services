package com.filter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;

import com.divers.LectEcrPerso;
import com.logs.GeneLog;

public class Filterer {

	protected AbstractFilter filter;
	
	protected final String cheminParam;
	
	public boolean testLog(GeneLog log) {
		return filter.tester(log);
	}
	
	public void majFilter() {
		File file = new File(cheminParam);
		FileReader fr;
		int res = 0;
	    try {
	    	
	    	fr = new FileReader(file);
	    	
	    	LectEcrPerso.nextInt(fr);
	    	LectEcrPerso.nextInt(fr);
	    	res = LectEcrPerso.nextInt(fr);
	    	
	    	fr.close();
	    	
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
		
		switch (res) {
		case 0:
			filter = new FilterTrue();
			break;
		// TODO raccrocher ici la génération des conditions
		
		// TODO rajouter aussi le cas ou on ne change que les paramètres et où l'on ne recréé pas la classe

		default:
			filter = new FilterTrue();
		}
	}
	
	public Filterer(String chemin) {
		cheminParam = chemin;
		majFilter();
	}

	public Collection<GeneLog> filtrerLogs(Collection<GeneLog> nvLogs) {
		GeneLog res = null;
		for (Iterator<GeneLog> it = nvLogs.iterator(); it.hasNext(); res = it.next())
			if (res != null && !filter.tester(res))
				it.remove();
		return nvLogs;
	}
}
