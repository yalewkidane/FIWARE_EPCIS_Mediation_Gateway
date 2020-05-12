//package com.oliot.mediation;
//
//import java.io.BufferedReader;
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileReader;
//import java.io.IOException;
//import java.io.Reader;
//
//import com.oliot.mediation.service.epcis.CaptureUtility;
//
//public class Test_EPCIS {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//		
//		Test_EPCIS test_EPCIS=new Test_EPCIS();
//		
//		try {
//			String xml2String = test_EPCIS.read_xml();
//			System.out.println(xml2String); 
//			
//			int status=CaptureUtility.registerEPCISAuth(xml2String);
//			
//			System.out.println(status);
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public String read_xml() throws IOException {
//		// our XML file for this example 
//		File xmlFile = new File("/root/Downloads/Project/FIWARE/Fiware_Oliot_Mediation/git2/FIWARE_EPCIS_Mediation_Gateway/src/main/java/com/oliot/mediation/event.xml"); 
//		// Let's get XML file as String using BufferedReader 
//		// FileReader uses platform's default character encoding 
//		// if you need to specify a different encoding, use InputStreamReader 
//		Reader fileReader = new FileReader(xmlFile); 
//		BufferedReader bufReader = new BufferedReader(fileReader); 
//		StringBuilder sb = new StringBuilder(); 
//		String line = bufReader.readLine(); 
//		while( line != null){ 
//			sb.append(line).append("\n"); 
//			line = bufReader.readLine(); 
//			} 
//		String xml2String = sb.toString(); 
//		
//		bufReader.close();
//		
//		return xml2String;
//	}
//
//}
