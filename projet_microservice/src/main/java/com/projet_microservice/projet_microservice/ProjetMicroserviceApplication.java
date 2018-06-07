package com.projet_microservice.projet_microservice;

//System.setProperty("javax.net.ssl.trustStore", "C:\Users\lmommeja\Desktop\keystore.jks");
//System.setProperty("javax.net.ssl.trustStorePassword", changeit);
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProjetMicroserviceApplication {
	public static void main(String[] args) {
		System.out.println("Wesh");
		SpringApplication.run(ProjetMicroserviceApplication.class, args);
	}
}
