package com.logmanagement;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import com.divers.LectEcrPerso;
import com.filter.Filterer;
import com.logs.GeneLog;
import com.logs.LogBuilder;

public class LogSender {

	protected final static String cheminOutput = "output.log";
	protected final static String cheminDocParam = "param.txt";
	// il se peut qu'un jour on ai plusieurs agents dans le meme endroit, alors il faudra paramètriser tout ça
	protected final String source;
	
	protected int logType;
	
	protected float period;
	protected Filterer tester;
	
	public LogSender(String source) {
		if (majVal() != 1) {
			period = 10f;
			logType = 0;
		}
		tester = new Filterer(cheminDocParam);
		this.source = source;
	}
	
	public int start() throws InterruptedException {
		Collection<GeneLog> nvLogs;
		File file = new File(source);
	    FileReader fr;
		boolean boucler = true;
		
		try {
			fr = new FileReader(file);
			while (boucler) {
				// TODO un système d'arrêt commandable depuis l'extérieur
				// TODO majVal pas trop souvent
				// TODO déphasage
				
				nvLogs = null;
				try {
					nvLogs = recupNvLogs(LectEcrPerso.lireFin(fr));
					
				} catch (FileNotFoundException e) {
			    	e.printStackTrace();
			    } catch (IOException e) {
			    	e.printStackTrace();
			    }
				
				nvLogs = tester.filtrerLogs(nvLogs);
				
				sendLogs(nvLogs);
				Thread.sleep((long) (1000 * period));
				
			}
			// fr.close();
		} catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    }
		
		
		return 1;
	}
	
	protected Collection<GeneLog> recupNvLogs(String s) {
		List<GeneLog> liste = new ArrayList<GeneLog>();
		for(String str : s.split("\n"))
			liste.add(LogBuilder.buildLog(str,logType));
		return liste;
	}

	protected void sendLogs(Collection<GeneLog> nvLogs) {
		// TODO 
		String res;
		for(GeneLog log : nvLogs) {
			res = log.toString();
			if (!LectEcrPerso.visible(res))
				System.out.println(res);
				
		}
	}

	public int majVal() {
		File file = new File(cheminDocParam);
		FileReader fr;
	    try {
	    	
	    	fr = new FileReader(file);
	    	
	    	logType = LectEcrPerso.nextInt(fr);
	    	period = LectEcrPerso.nextInt(fr);
	    	
	    	fr.close();
	    	
	    } catch (FileNotFoundException e) {
	    	e.printStackTrace();
	    	return 0;
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	return 0;
	    }
		return 1; // aucun problèmes rencontrés
	}
	
	protected GeneLog instanciateLog(String log) {
		return LogBuilder.buildLog(log,logType);
	}
	
}
