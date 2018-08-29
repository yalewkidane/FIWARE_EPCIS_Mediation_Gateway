package com.oliot.mediation.service.fiware;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

import com.oliot.mediation.service.epcis.QueryResonse;

public class QueryUtilility {
	
	public static QueryResonse normalquery(String url) throws IOException {
		QueryResonse response=new QueryResonse();
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestMethod("GET");
		con.connect();
		System.out.println("url" + url);
		if(con.getResponseCode() != 200) {
			response.setBody("{}");
			response.setStaus("Failed : HTTP error code : " + con.getResponseCode());
			System.out.println("Failed : HTTP error code : " + con.getResponseCode());
		}else {
			//Print response headers
			//System.out.println("\nResponse Headers:\n");
			Map<String, List<String>> map = con.getHeaderFields();
			for(Map.Entry<String, List<String>> entry : map.entrySet()) {
				//System.out.println(entry.getKey() + ": " + entry.getValue());
			}

			//Get response body and print it
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), "UTF-8"));
			String output;
			StringBuffer result = new StringBuffer();


			while ((output = br.readLine()) != null) {
				result.append(output);
				if(output.compareTo("") != 0) {
					result.append("\n");
				}
			}
			br.close();
			
			response.setBody(result.toString());
			response.setStaus("Success : HTTP status code : " + con.getResponseCode());
			System.out.println("Success : HTTP status code : " + con.getResponseCode());
		}

		

		con.disconnect();

		return response;

	}
	
	public static String get(String url) {
		String result="Status";
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("GET");
			con.connect();

			if(con.getResponseCode() != 200) {
				result="Failed : HTTP error code : " + con.getResponseCode();
			}else {
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
				
				result=response.toString();
			}
			
			con.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

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
	
	public static String patch(String url, String body) throws IOException {
		String response="Staus";
		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();
		con.setRequestProperty("X-HTTP-Method-Override", "PATCH");
		con.setRequestMethod("POST");
		con.setDoOutput(true);
		con.setRequestProperty("Content-Type", "application/json");
		if (body != null) {
			con.setRequestProperty("Content-Length", Integer.toString(body.length()));
			con.getOutputStream().write(body.getBytes("UTF8"));
			}
		con.connect();
		

		if((con.getResponseCode()!= 204)) {
			response="Failed : HTTP error code : " + con.getResponseCode();
		}else {
			response="Success : HTTP status code : " + con.getResponseCode();
		}

		con.disconnect();

		return response.toString();

	}
	
	public static String delete(String url) {
		String result="Status";
		URL obj;
		try {
			obj = new URL(url);
			HttpURLConnection con = (HttpURLConnection) obj.openConnection();
			con.setRequestMethod("DELETE");
			con.connect();

			if(con.getResponseCode() != 200) {
				result="Failed : HTTP error code : " + con.getResponseCode();
			}else {
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
				
				result=response.toString();
			}
			
			con.disconnect();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return result;

	}
	
	
	
	
	
	

}
