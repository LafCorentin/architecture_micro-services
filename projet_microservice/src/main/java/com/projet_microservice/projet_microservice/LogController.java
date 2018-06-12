package com.projet_microservice.projet_microservice;
import org.springframework.web.bind.annotation.*;
import com.logs.logXMLTest;
import com.logs.GeneLog;
import com.dao.LogDao;
import com.dao.GeneLogDaoImpl;
import org.springframework.stereotype.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.ArrayList;
import java.util.List;
import java.lang.String;
import java.util.Date;

@RestController
public class LogController {
	
	    @Autowired(required=false)
	    public GeneLogDaoImpl LogDao;
	
	    //Récupérer la liste compleste des logs
	    @RequestMapping(value="/ListeLogs", method=RequestMethod.GET)
	    public List <GeneLog> listeLogs() {
	        return LogDao.findAll();
	    }
	   
	    
	    @GetMapping(value = "/SeverityLvl/{lvl}")
	    public String afficherUnLogSeverityLvl(@PathVariable int lvl) {
	    	return (LogDao.findBySeverityLvl(lvl)).toString();
	    }
	    
	    @GetMapping(value = "/afficherUnLog")
	    public String afficherUnLog() {
	    	// Devra prendre en argument un log et l'afficher
	    	logXMLTest log = new logXMLTest(new String("Contenu du log d'Id="));
	        return (log.getData()+log.getID());
	    }
	    


	    
//	    @GetMapping(value = "/afficherUnLog")
//	    public String afficherUnLog() {
//	    	// Devra prendre un argument un log et son iD et l'afficher
//	    	logXMLTest log = new logXMLTest(new String("Contenu du log"));
//	        return log.getData();
//	    }
}
