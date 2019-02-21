package com.oliot.mediation.service.epcis;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.oliot.mediation.service.gs1Source.CaptureGs1Source;
public class Test {

	/*
	public static void main(String[] args) throws JsonParseException, JsonMappingException, IOException, NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		// TODO Auto-generated method stub
		
		
		
		
		String data ="<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" + 
				"<!--\n" + 
				"  ~ Copyright 2017 Open Language for Internet of Things (Oliot)\n" + 
				"  ~\n" + 
				"  ~ Licensed under the Apache License, Version 2.0 (the \"License\");\n" + 
				"  ~ you may not use this file except in compliance with the License.\n" + 
				"  ~ You may obtain a copy of the License at\n" + 
				"  ~\n" + 
				"  ~     http://www.apache.org/licenses/LICENSE-2.0\n" + 
				"  ~\n" + 
				"  ~ Unless required by applicable law or agreed to in writing, software\n" + 
				"  ~ distributed under the License is distributed on an \"AS IS\" BASIS,\n" + 
				"  ~ WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.\n" + 
				"  ~ See the License for the specific language governing permissions and\n" + 
				"  ~ limitations under the License.\n" + 
				"  -->\n" + 
				"\n" + 
				"<product_data:productData xmlns:product_data=\"urn:gs1:tsd:product_data:xsd:1\"\n" + 
				"                          xmlns:bus_line_information_module=\"urn:gs1:tsd:bus_line_information_module:xsd:1\">\n" + 
				"    <epcURI>urn:entity:busan:transport:bus:busStop:0014</epcURI>\n" + 
				"    <targetMarket codeListVersion=\"1.1\">410</targetMarket>\n" + 
				"    <informationProviderGLN>1234567891234</informationProviderGLN>\n" + 
				"    <informationProviderName>Lotte Mart</informationProviderName>\n" + 
				"    <productDataRecord>\n" + 
				"        <module>\n" + 
				"            <bus_line_information_module:busLineInformationModule>\n" + 
				"                <refBusStops>\n" + 
				"                    <type>Structuredvalue</type>\n" + 
				"                    <value>urn:entity:busan:transport:bus:busStop:001</value>\n" + 
				"                    <value>urn:entity:busan:transport:bus:busStop:002</value>\n" + 
				"                    <value>urn:entity:busan:transport:bus:busStop:003</value>\n" + 
				"                </refBusStops>\n" + 
				"\n" + 
				"                <localID>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>104</value>\n" + 
				"                </localID>\n" + 
				"\n" + 
				"                <shortID>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>5200104000</value>\n" + 
				"                </shortID>\n" + 
				"\n" + 
				"                <name>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>PENACASTILLO – PLAZA DE ITALIA</value>\n" + 
				"                </name>\n" + 
				"\n" + 
				"                <refStartBusStop>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>urn:entity:busan:transport:bus:busStop:001</value>\n" + 
				"                </refStartBusStop>\n" + 
				"\n" + 
				"                <refEndBusStop>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>urn:entity:busan:transport:bus:busStop:002</value>\n" + 
				"                </refEndBusStop>\n" + 
				"\n" + 
				"                <busLineType>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>standard</value>\n" + 
				"                </busLineType>\n" + 
				"\n" + 
				"                <startTime>\n" + 
				"                    <type>ISO8601</type>\n" + 
				"                    <value>2017-02-05T08:15:30-05:09</value>\n" + 
				"                </startTime>\n" + 
				"\n" + 
				"                <endTime>\n" + 
				"                    <type>ISO8601</type>\n" + 
				"                    <value>2017-02-05T08:15:30-05:09</value>\n" + 
				"                </endTime>\n" + 
				"\n" + 
				"                <intervalNorm>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>P3Y6M4DT12H30M5S</value>\n" + 
				"                </intervalNorm>\n" + 
				"\n" + 
				"                <intervalHoli>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>P3Y6M4DT12H30M5S</value>\n" + 
				"                </intervalHoli>\n" + 
				"\n" + 
				"                <intervalPeak>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>P3Y6M4DT12H30M5S</value>\n" + 
				"                </intervalPeak>\n" + 
				"\n" + 
				"                <dateModified>\n" + 
				"                    <type>ISO8601</type>\n" + 
				"                    <value>2017-02-05T08:15:30-05:09</value>\n" + 
				"                </dateModified>\n" + 
				"            </bus_line_information_module:busLineInformationModule>\n" + 
				"        </module>\n" + 
				"    </productDataRecord>\n" + 
				"</product_data:productData>\n" + 
				"\n" + 
				"";
		String busxml;
		String status=CaptureGs1Source.registerGS1Source(busxml=CaptureGs1Source.getBusStopxml(), "editor")+"";
		
		//String status=CaptureGs1Source.registerGS1Source(CaptureGs1Source.getBusLineXml(), "editor")+"";
		System.out.println(busxml);
		System.out.println("--------------------");
		System.out.println(status);
		// 35.179729,129.074997
		
		//43.462346, -3.809978
		//System.out.println(Utility.coordinta_sgln_converter(35.179729,129.074997));
		
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
	*/

}
