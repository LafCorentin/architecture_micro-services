package filter;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Iterator;
import com.logs.GeneLog;

public class Filterer {

	protected AbstractFilter filter;
	
	protected final String cheminParam;
	
	public boolean testLog(GeneLog log) {
		return filter.tester(log);
	}
	
	public void majFilter() {
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
