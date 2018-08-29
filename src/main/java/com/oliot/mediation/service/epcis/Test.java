package com.oliot.mediation.service.epcis;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
public class Test {

	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		String jsonString="{\"id\": \"Room1\",\"type\": \"Room\" ,\n" + 
				"    \"pressure\": {\n" + 
				"        \"type\": \"Integer\",\n" + 
				"        \"value\": 718\n" + 
			
				"    } ,\n" + 
				"    \"temperature\": {\n" + 
				"        \"type\": \"Float\",\n" + 
				"        \"value\": 24,\n" + 
				"        \"metadata\": {}\n" + 
				"    }}";
		String carExample="{\n" + 
				"    \"id\": \"Car1\",\n" + 
				"    \"type\": \"Car\",\n" + 
				"    \"speed\": {\n" + 
				"        \"type\": \"Float\",\n" + 
				"        \"value\": 115,\n" + 
				"        \"metadata\": {}\n" + 
				"    }\n" + 
				"}";
		String test="{\"subscriptionId\":\"5b45a208b956cd2b98687d0b\",\"data\":[{\"id\":\"Room4\",\"type\":\"Room\",\"pressure\":{\"type\":\"Integer\",\"value\":723,\"metadata\":{}},\"temperature\":{\"type\":\"Float\",\"value\":14,\"metadata\":{}}}]}";
		System.out.println(test.indexOf("\"data\":["));
		System.out.println(test.length()-2);
		test=test.substring(test.indexOf("\"data\":[")+8, test.length()-2);
		System.out.println(test);
		System.out.println(jsonString);
		//CaptureEPCIS captureEPCIS=new CaptureEPCIS();
		//String result=captureEPCIS.capture(jsonString, "Test/Room");
		//String result=captureEPCIS.capture(carExample, "Test/Car");

	}

}
