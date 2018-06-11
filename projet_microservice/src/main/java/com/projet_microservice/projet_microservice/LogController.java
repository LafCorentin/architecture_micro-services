package com.projet_microservice.projet_microservice;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@RestController
public class LogController {
	    @RequestMapping(value="/ListeLogs", method=RequestMethod.GET)
	    public String listeLogs() {
	        return "Ceci est un exemple de log sous forme de string";
	    }
//	    @GetMapping(value = "/ListeLogs/{id}")
//	    public String afficherUnLog(@PathVariable int id) {
//	    	Log log=new Log(id, new String("Contenu du log"));
//	        return log;
//	    }
}
