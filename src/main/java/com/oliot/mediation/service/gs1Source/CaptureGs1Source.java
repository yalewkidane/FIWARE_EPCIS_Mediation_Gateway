package com.oliot.mediation.service.gs1Source;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;

import com.oliot.mediation.configuration.Configuration;
import com.oliot.model.fiware.Bus.BusLine;
import com.oliot.model.fiware.Bus.BusStop;


public class CaptureGs1Source {
	///Bus/BusLine /Bus/BusStop
	
	
	

	
	public static String getBusStopxml(BusStop busStop) {
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
				"                          xmlns:bus_stop_information_module=\"urn:gs1:tsd:bus_stop_information_module:xsd:1\">\n" + 
				"    <epcURI>"+busStop.getId()+"</epcURI>\n" + 
				"    <targetMarket codeListVersion=\"1.1\">410</targetMarket>\n" + 
				"    <informationProviderGLN>1234567891234</informationProviderGLN>\n" + 
				"    <informationProviderName>Lotte Mart</informationProviderName>\n" + 
				"    <productDataRecord>\n" + 
				"        <module>\n" + 
				"            <bus_stop_information_module:busStopInformationModule>\n";
		if(busStop.getShortID()!=null)
			data+=	"\n" + 
				"                <shortID>\n" + 
				"                    <type>"+busStop.getShortID().getType()+"</type>\n" + 
				"                    <value>"+busStop.getShortID().getValue()+"</value>\n" + 
				"                </shortID>\n";
		if(busStop.getName()!=null)
			data+="\n" + 
				"                <name>\n" + 
				"                    <type>"+busStop.getName().getType()+"</type>\n" + 
				"                    <value>"+busStop.getName().getValue()+"</value>\n" + 
				"                </name>\n" ;
		if(busStop.getRefBusLines()!=null) {
			data+="\n" + 
					"                <refBusLines>\n" + 
					"                    <type>"+busStop.getRefBusLines().getType()+"</type>\n" ;
			if(busStop.getRefBusLines().getValue()!=null) {
				for (int i=0; i< busStop.getRefBusLines().getValue().size(); i++)
					data+="                    <value>urn:entity:busan:transport:bus:busStop:1</value>\n";
			}
			data+=	"                    <value>urn:entity:busan:transport:bus:busStop:1</value>\n" + 
					"                </refBusLines>\n" ;
		}
			
		
		
		if(busStop.getGeolocation()!=null)
			data+=	"\n" + 
				"        <geolocation>\n" + 
				"            <type>"+busStop.getGeolocation().getType()+"</type>\n" + 
				"            <value>\n" + 
				"            <type>"+busStop.getGeolocation().getValue().getType()+"</type>\n" ; 
				if(busStop.getGeolocation().getValue().getCoordinates()!=null)
					for(int i=0; i<busStop.getGeolocation().getValue().getCoordinates().size(); i++)
						data+="            <coordinates>"+busStop.getGeolocation().getValue().getCoordinates().get(i)+"</coordinates>\n" ; 
		data+="            </value>\n" + 
				"        </geolocation>\n" ;
		
		if(busStop.getAddress()!=null)
			data+="\n" + 
				"        <address>\n" + 
				"            <type>"+busStop.getAddress().getType()+"</type>\n" + 
				"            <value>\n" + 
				"            <type>"+busStop.getAddress().getValue().getType()+"</type>\n" + 
				"            <addressLocality>"+busStop.getAddress().getValue().getAddressLocality()+"</addressLocality>\n" + 
				"            <addressRegion>"+busStop.getAddress().getValue().getAddressRegion()+"</addressRegion>\n" + 
				"            <postalCode>"+busStop.getAddress().getValue().getPostalCode()+"</postalCode>\n" + 
				"            <streetAddress>"+busStop.getAddress().getValue().getStreetAddress()+"</streetAddress>\n" + 
				"            </value>\n" + 
				"        </address>\n" ;
		
		if(busStop.getDateModified()!=null)
			data+="\n" + 
				"                <dateModified>\n" + 
				"                    <type>"+busStop.getDateModified().getType()+"</type>\n" + 
				"                    <value>"+busStop.getDateModified().getValue()+"</value>\n" + 
				"                </dateModified>\n" + 
				"            </bus_stop_information_module:busStopInformationModule>\n" + 
				"        </module>\n" + 
				"    </productDataRecord>\n" + 
				"</product_data:productData>\n" + 
				"\n" + 
				"";
		
		return data;
	}
	
	
	
	
	
	public static String getBusLineXml(BusLine busLine) {
		
		
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
				"    <epcURI>"+busLine.getId()+"</epcURI>\n" + 
				"    <targetMarket codeListVersion=\"1.1\">410</targetMarket>\n" + 
				"    <informationProviderGLN>1234567891234</informationProviderGLN>\n" + 
				"    <informationProviderName>Lotte Mart</informationProviderName>\n" + 
				"    <productDataRecord>\n" + 
				"        <module>\n" + 
				"            <bus_line_information_module:busLineInformationModule>\n" ;
		if(busLine.getRefBusStops()!=null)
			data +="                <refBusStops>\n" + 
				"                    <type>Structuredvalue</type>\n" ;
		if(busLine.getRefBusStops().getValue()!=null)
			for(int i=0; i< busLine.getRefBusStops().getValue().size(); i++)
				data +="                    <value>"+busLine.getRefBusStops().getValue().get(i)+"</value>\n"; 
		data +="                </refBusStops>\n" ;
		
		if(busLine.getLocalID()!=null)
			data +="\n  <localID>\n" + 
				"                    <type>"+busLine.getLocalID().getType()+"</type>\n" + 
				"                    <value>"+busLine.getLocalID().getValue()+"</value>\n" + 
				"                </localID>\n" ; 
		
		if(busLine.getShortID()!=null)
			data +="\n <shortID>\n" + 
				"                    <type>"+busLine.getShortID().getType()+"</type>\n" + 
				"                    <value>"+busLine.getShortID().getValue()+"</value>\n" + 
				"                </shortID>\n" ;
		
		if(busLine.getName()!=null)
			data +="\n" + 
				"                <name>\n" + 
				"                    <type>"+busLine.getName().getType()+"</type>\n" + 
				"                    <value>"+busLine.getName().getValue()+"</value>\n" + 
				"                </name>\n" ;
		if(busLine.getRefStartBusStop()!=null)
			data +="\n" + 
				"                <refStartBusStop>\n" + 
				"                    <type>"+busLine.getRefStartBusStop().getType()+"</type>\n" + 
				"                    <value>"+busLine.getRefStartBusStop().getValue()+"</value>\n" + 
				"                </refStartBusStop>\n" ;
		if(busLine.getRefEndBusStop()!=null)
			data +="\n" + 
				"                <refEndBusStop>\n" + 
				"                    <type>"+busLine.getRefEndBusStop().getType()+"</type>\n" + 
				"                    <value>"+busLine.getRefEndBusStop().getValue()+"</value>\n" + 
				"                </refEndBusStop>\n" ;
		if(busLine.getBusLineType()!=null)
			data +="\n" + 
				"                <busLineType>\n" + 
				"                    <type>"+busLine.getBusLineType().getType()+"</type>\n" + 
				"                    <value>"+busLine.getBusLineType().getValue()+"</value>\n" + 
				"                </busLineType>\n" ;
		if(busLine.getStartTime()!=null)
			data +="\n" + 
				"                <startTime>\n" + 
				"                    <type>"+busLine.getStartTime().getType()+"</type>\n" + 
				"                    <value>"+busLine.getStartTime().getValue()+"</value>\n" + 
				"                </startTime>\n" ;
		if(busLine.getEndTime()!=null)
			data +="\n" + 
				"                <endTime>\n" + 
				"                    <type>"+busLine.getEndTime().getType()+"</type>\n" + 
				"                    <value>"+busLine.getEndTime().getValue()+"</value>\n" + 
				"                </endTime>\n" ;
		if(busLine.getIntervalNorm()!=null)
			data +="\n" + 
				"                <intervalNorm>\n" + 
				"                    <type>"+busLine.getIntervalNorm().getType()+"</type>\n" + 
				"                    <value>"+busLine.getIntervalNorm().getValue()+"</value>\n" + 
				"                </intervalNorm>\n" ;
		if(busLine.getIntervalHoli()!=null)
			data +="\n" + 
				"                <intervalHoli>\n" + 
				"                    <type>"+busLine.getIntervalHoli().getType()+"</type>\n" + 
				"                    <value>"+busLine.getIntervalHoli().getValue()+"</value>\n" + 
				"                </intervalHoli>\n" ;
		if(busLine.getIntervalPeak()!=null)
			data +="\n" + 
				"                <intervalPeak>\n" + 
				"                    <type>"+busLine.getIntervalPeak().getType()+"</type>\n" + 
				"                    <value>"+busLine.getIntervalPeak().getValue()+"</value>\n" + 
				"                </intervalPeak>\n" ;
		if(busLine.getDateModified()!=null)
			data +="\n" + 
				"                <dateModified>\n" + 
				"                    <type>"+busLine.getDateModified().getType()+"</type>\n" + 
				"                    <value>"+busLine.getDateModified().getValue()+"</value>\n" + 
				"                </dateModified>\n" ; 
		data +="            </bus_line_information_module:busLineInformationModule>\n" + 
				"        </module>\n" + 
				"    </productDataRecord>\n" + 
				"</product_data:productData>\n" + 
				"\n" + 
				"";
		
		return data; 
	}
	
	
	public static String getBusStopxml() {
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
				"                          xmlns:bus_stop_information_module=\"urn:gs1:tsd:bus_stop_information_module:xsd:1\">\n" + 
				"    <epcURI>urn:epc:id:sgln:88000269.9101.000001514124218</epcURI>\n" + 
				"    <targetMarket codeListVersion=\"1.1\">410</targetMarket>\n" + 
				"    <informationProviderGLN>1234567891234</informationProviderGLN>\n" + 
				"    <informationProviderName>Lotte Mart</informationProviderName>\n" + 
				"    <productDataRecord>\n" + 
				"        <module>\n" + 
				"            <bus_stop_information_module:busStopInformationModule>\n"+
				"\n" + 
				"                <shortID>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>11161</value>\n" + 
				"                </shortID>\n"+ 
				"\n" + 
				"                <name>\n" + 
				"                    <type>String</type>\n" + 
				"                    <value>city hall</value>\n" + 
				"                </name>\n" + 
				"\n" + 
				"                <refBusLines>\n" + 
				"                    <type>Structuredvalue</type>\n" +
			    "                    <value>urn:entity:busan:transport:bus:busStop:1</value>\n"+
		    	"                    <value>urn:entity:busan:transport:bus:busStop:1</value>\n" + 
				"                </refBusLines>\n" + 
				"\n" + 
				"        <geolocation>\n" + 
				"            <type>geo:json</type>\n" + 
				"            <value>\n" + 
				"            <type>Point</type>\n" + 
				"            <coordinates>-3.878289196</coordinates>\n" + 
				"            <coordinates>43.438962839</coordinates>\n" + 
				"            </value>\n" + 
				"        </geolocation>\n" + 
				"\n" + 
				"        <address>\n" + 
				"            <type>Text</type>\n" + 
				"            <value>\n" + 
				"            <type>Text</type>\n" + 
				"            <addressLocality>Denver</addressLocality>\n" + 
				"            <addressRegion>CO</addressRegion>\n" + 
				"            <postalCode>80209</postalCode>\n" + 
				"            <streetAddress>7 S. Broadway</streetAddress>\n" + 
				"            </value>\n" + 
				"        </address>\n" + 
				"\n" + 
				"                <dateModified>\n" + 
				"                    <type>ISO8601</type>\n" + 
				"                    <value>2017-02-05T08:15:30-05:09</value>\n" + 
				"                </dateModified>\n" + 
				"            </bus_stop_information_module:busStopInformationModule>\n" + 
				"        </module>\n" + 
				"    </productDataRecord>\n" + 
				"</product_data:productData>\n" + 
				"\n" + 
				"";
		
		return data;
	}
	
	
	public static String getBusLineXml() {
		
		
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
				"    <epcURI>urn:entity:busan:transport:bus:busStop:0015</epcURI>\n" + 
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
		
		return data; 
	}
	
	public static int registerGS1Source(String data, String par) throws UnsupportedEncodingException {

		String url = Configuration.gs1SourceURL + "/insert";
		
		System.out.println("GS1 Source Url: "+ url);
	

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);
		
		ArrayList<NameValuePair> postpar=new ArrayList<NameValuePair>();
		
		postpar.add(new BasicNameValuePair(par, data));
		post.setEntity(new UrlEncodedFormEntity(postpar, "UTF-8"));

		//post.setEntity(new StringEntity(data, "UTF-8"));

		HttpResponse response = null;
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		

		return response.getStatusLine().getStatusCode();
	}

}
