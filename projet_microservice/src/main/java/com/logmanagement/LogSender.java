package com.logmanagement;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.List;

import com.logs.GeneLog;
import com.logs.logXMLTest;

import filter.Filterer;

public class LogSender {

	protected final static String cheminOutput = "http.serveur_inconnu.com/BDD";
	protected final static String cheminDocParam = "src/paramAgent.json";
	// il se peut qu un jour j ai plusieurs agents dans le meme endroit alors il faudra parametriser tout ça
	protected final String source;
	
	protected float period;
	protected Filterer tester;
	
	public LogSender(String source) {
		if (majPeriod() != 1)
			period = 10f;
		tester = new Filterer(cheminDocParam);
		this.source = source;
	}
	
	
	public int start() {
		Collection<GeneLog> nvLogs;
		boolean boucler = true;
		while (boucler) {
			// TODO un systeme d arret commandable depuis l extérieur
			// TODO majPeriod et majFiltre pas trop souvent
			
			nvLogs = recupNvLogs();
			
			nvLogs = tester.filtrerLogs(nvLogs);
			
			sendLogs(nvLogs);
		}
		return 1;
	}
	
	protected void sendLogs(Collection<GeneLog> nvLogs) {
		// TODO Auto-generated method stub	
	}

	public int majPeriod() {
		DataInputStream dis = null;
		float res = -1f;
		try {
			dis = new DataInputStream(
					new FileInputStream(
						new File(cheminDocParam)));
			res = dis.readInt();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return 0;
	    } catch (IOException e) {
	    	e.printStackTrace();
	    	return 0;
		} finally {
			if (dis != null) 
				try {dis.close();} catch (IOException logOrIgnore) {}
		}
		if (res<0)
			return 0;
		period = res;
		return 1; // aucun problèmes rencontrés
	}
	
	protected GeneLog instanciateLog(String log) {
		GeneLog res;
		if (true) 
			// TODO gérer les différents types de log, peut être le définir lors de la création de la classe... :/
			res = new logXMLTest(log);
		return res;
	}
	
	protected Collection<GeneLog> recupNvLogs() {
		// TODO	(et les stocker dans une liste, quite à la renverser à la fin pour qu'ils soient dans l'ordre)
		List<GeneLog> res = null;
		return res;
	}
}
