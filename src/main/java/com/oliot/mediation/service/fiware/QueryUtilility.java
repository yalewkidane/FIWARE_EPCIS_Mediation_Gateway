package com.oliot.mediation.service.fiware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class QueryUtilility {
	
	public static String normalquery(String url) throws IOException {

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.connect();

		if(con.getResponseCode() != 200) {
			System.out.println("Failed : HTTP error code : " + con.getResponseCode());
		}

		//Print response headers
		//System.out.println("\nResponse Headers:\n");
		Map<String, List<String>> map = con.getHeaderFields();
		for(Map.Entry<String, List<String>> entry : map.entrySet()) {
			//System.out.println(entry.getKey() + ": " + entry.getValue());
		}

		//Get response body and print it
		BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
		String output;
		StringBuffer response = new StringBuffer();


		while ((output = br.readLine()) != null) {
			response.append(output);
			if(output.compareTo("") != 0) {
				response.append("\n");
			}
		}
		br.close();

		con.disconnect();

		return response.toString();

	}
	
	public static String post(String url, String body) throws IOException {
		String response="Staus";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");
		if (body != null) {
			con.setRequestProperty("Content-Length", Integer.toString(body.length()));
			con.getOutputStream().write(body.getBytes("UTF8"));
			}
		con.connect();
		

		if(con.getResponseCode() != 201) {
			response="Failed : HTTP error code : " + con.getResponseCode();
		}else {
			response="Success : HTTP status code : " + con.getResponseCode();
		}

		con.disconnect();

		return response.toString();

	}
	
	public static String delete(String url, String body) throws IOException {
		String response="Staus";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");
		if (body != null) {
			con.setRequestProperty("Content-Length", Integer.toString(body.length()));
			con.getOutputStream().write(body.getBytes("UTF8"));
			}
		con.connect();
		

		if(con.getResponseCode() != 201) {
			response="Failed : HTTP error code : " + con.getResponseCode();
		}else {
			response="Success : HTTP status code : " + con.getResponseCode();
		}

		con.disconnect();

		return response.toString();

	}
	
	
	
	
	
	

}
