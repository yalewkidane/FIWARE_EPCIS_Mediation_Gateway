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

import com.github.jedis.lock.JedisLock;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

import redis.clients.jedis.Jedis;

public class Configuration {
	public static String fiwareURL="143.248.57.28:1026";
	public static String epcisURL="143.248.55.183:8080";
	public static String mediationGatewayPort="8081";//"8092";8081
	public static String mediationGatewayURL="127.0.0.1:8081";
	public static Logger logger;
	public static String gs1SourceURL="http://182.252.135.133:8010";//"https://bus-poc.herokuapp.com";
	
	//public static Jedis jedi;
	//public static  JedisLock jedi_lock;
	
	public static Table<String, String, Double> table = HashBasedTable.create(); 
	
	public static String farm_pig="urn:gs1:epcisapp:farm:pig";
	public static String sgtin="urn:epc:id:sgtin:";
	public static String sgln="urn:epc:id:sgln:";
	public static String Pig_ItemReference="444";
	public static String ilvo_CompanyPrefix="88000269";
	
	//For test purpose 
	public static boolean epcis_Ststus=false;
	public static String epcis_String;
	public static int increase_weight=1; 
	public static int Farm_Building=0;
	public static int Farm_Pig=0;
	
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
		//System.out.println("Enter GS1 Source server URL (e.g http://localhost:8080): ");
		//gs1SourceURL = scanner.nextLine();
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
