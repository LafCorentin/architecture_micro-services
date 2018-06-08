package com.logmanagement;

import com.logs.GeneLog;
import com.logs.logXMLTest;

public class LogSender {

	protected final static String cheminOutput = "http.serveur_inconnu.com/BDD";
	protected final static String cheminDocParam = "src/paramAgent.txt";
	// il se peut qu'un jour ai plusieurs agents dans le meme endroit, alors il faudra paramètriser tout ça
	
	protected float period;
	protected LogTester tester;
	
	public LogSender(float time_in_seconds) {
		period = time_in_seconds;
	}
	
	public int start() {
		while (true) {
			// TODO un système d'arrêt commandable depuis l'extérieur
			// TODO majPeriod et majFiltre pas trop souvent
			
			return 1;
		}
	}
	
	public int majPeriod() {
		
		// TODO maj de period suivant les informations dans le fichier des paramètres.
		
		return 1; // aucun problèmes rencontrés
	}
	
	protected boolean testLog() {
		// TODO les fonctions de tests du log
		return true;
	}
	
	protected GeneLog instanciate(String log) {
		GeneLog res;
		if (true) 
			// TODO gérer les différents types de log, peut être le définir lors de la création de la classe... :/
			res = new logXMLTest(log);
		return res;
	}
}
