package com.oliot.mediation;

import java.util.Collections;
import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.github.jedis.lock.JedisLock;
import com.oliot.mediation.configuration.Configuration;

import redis.clients.jedis.Jedis;

@SpringBootApplication
@ComponentScan({"com.oliot.mediation.controller"})
public class FiwareOiliotMediationApplication {

	
	
	public static void main(String[] args) {
		
		
		new Configuration().configurationInitialized();
		
		SpringApplication app = new SpringApplication(FiwareOiliotMediationApplication.class);
        app.setDefaultProperties(Collections.singletonMap("server.port", Configuration.mediationGatewayPort));
        //app.setDefaultProperties(Collections.singletonMap("server.connection-timeout", "900000"));
        app.run(args);
		//server.connection-timeout
        //String[] defaultProfiles = app.getAllSources();
       // System.out
        
		//SpringApplication.run(FiwareOiliotMediationApplication.class, args);
		
        //Configuration.jedi = new Jedis("localhost",6379,200000);
        
        
        //Configuration.jedi = new Jedis("localhost",6379,200000);
        //Configuration.jedi_lock = new JedisLock(Configuration.jedi, "lockname", 10000, 300000);
		
		
	}
}




