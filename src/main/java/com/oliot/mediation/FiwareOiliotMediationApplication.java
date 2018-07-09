package com.oliot.mediation;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.oliot.mediation.configuration.Configuration;

@SpringBootApplication
@ComponentScan({"com.oliot.mediation.controller"})
public class FiwareOiliotMediationApplication {

	
	
	public static void main(String[] args) {
		
		
		new Configuration().configurationInitialized();
		
		SpringApplication app = new SpringApplication(FiwareOiliotMediationApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", Configuration.mediationGatewayPort));
        app.run(args);
		
		//SpringApplication.run(FiwareOiliotMediationApplication.class, args);
		
				
		
		
	}
}




