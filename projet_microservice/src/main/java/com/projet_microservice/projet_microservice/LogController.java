package com.projet_microservice;
import org.springframework.web.bind.annotation.*;
import com.logs.logXMLTest;
import org.springframework.stereotype.Controller;
import com.logs.GeneLog;
//import java.lang.String;
//import java.util.Date;

@RestController
public class LogController {
	    @RequestMapping(value="/ListeLogs", method=RequestMethod.GET)
	    public String ListeLogs() {
	        return "Ceci est un exemple de log sous forme de string";
	    }
	    
//	    @GetMapping(value = "/ListeLogs/{id}")
//	    public String afficherUnLog(GeneLog log) {
//	    	return log.getData();
//	    }
	    
//	    @GetMapping(value = "/afficherUnLog")
//	    public String afficherUnLog() {
//	    	logXMLTest log = new logXMLTest(new String("Contenu du log"));
//	        return log.getData();
//	    }
}
