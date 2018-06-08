package com.logmanagement;

import com.logs.GeneLog;
import com.logs.logXMLTest;

public class LogSender {

	protected final static String cheminOutput = "http.serveur_inconnu.com/BDD";
	protected final static String cheminDocParam = "src/paramAgent.txt";
	// il se peut qu'un jour ai plusieurs agents dans le meme endroit, alors il faudra param�triser tout �a
	
	protected float period;
	protected LogTester tester;
	
	public LogSender(float time_in_seconds) {
		period = time_in_seconds;
	}
	
	public int start() {
		while (true) {
			// TODO un syst�me d'arr�t commandable depuis l'ext�rieur
			// TODO majPeriod et majFiltre pas trop souvent
			
			return 1;
		}
	}
	
	public int majPeriod() {
		
		// TODO maj de period suivant les informations dans le fichier des param�tres.
		
		return 1; // aucun probl�mes rencontr�s
	}
	
	protected boolean testLog() {
		// TODO les fonctions de tests du log
		return true;
	}
	
	protected GeneLog instanciate(String log) {
		GeneLog res;
		if (true) 
			// TODO g�rer les diff�rents types de log, peut �tre le d�finir lors de la cr�ation de la classe... :/
			res = new logXMLTest(log);
		return res;
	}
}
