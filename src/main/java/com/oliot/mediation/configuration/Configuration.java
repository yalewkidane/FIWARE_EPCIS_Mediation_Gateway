package com.oliot.mediation.configuration;

import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

public class Configuration {
	public static String fiwareURL="localhost:1026";
	public static String epcisURL="localhost:8080";
	public static String mediationGatewayPort="8081";
	public static String mediationGatewayURL="localhost:8081";
	public static Logger logger;
	
	@Autowired
	Environment environment;
	
	
	public void configurationInitialized() {
		// Set Logger
		setLogger();
		
		// set  Login page 
		setServerURL();
	}
	
	private void setLogger() {
		// Log4j Setting
		BasicConfigurator.configure();
		Logger.getRootLogger().setLevel(Level.INFO);
		Configuration.logger = Logger.getRootLogger();
		Configuration.logger.info("Log configuration started");
	}

	
	private void setServerURL(){
		@SuppressWarnings("resource")
		Scanner scanner =new Scanner(System.in);
		System.out.println("Enter FIWARE server URL (e.g localhost:2016): ");
		fiwareURL = scanner.nextLine();
		System.out.println("Enter EPCIS server URL (e.g localhost:8080): ");
		epcisURL = scanner.nextLine();
		System.out.println("Mediation Gateway Port  (e.g 8083): ");
		mediationGatewayPort = scanner.nextLine();
		
		try(final DatagramSocket socket = new DatagramSocket()){
		  socket.connect(InetAddress.getByName("8.8.8.8"), 10002);
		  String ip = socket.getLocalAddress().getHostAddress();
		  
		  mediationGatewayURL=ip+":"+mediationGatewayPort;
		  
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		Configuration.logger.info("FIWARE URL: "+ Configuration.fiwareURL);
		Configuration.logger.info("EPCIS URL: "+ Configuration.epcisURL);
		Configuration.logger.info("mediationGateway URL: "+ Configuration.mediationGatewayURL);
	}
	
	
}
