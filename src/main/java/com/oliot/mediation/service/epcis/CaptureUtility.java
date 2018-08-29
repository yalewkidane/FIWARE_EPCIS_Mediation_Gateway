package com.oliot.mediation.service.epcis;

import java.io.IOException;


import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import com.oliot.mediation.configuration.Configuration;



public class CaptureUtility {
	
	public static int registerEPCIS(String data) {

		String url = "http://" + Configuration.epcisURL + "/epcis/Service/EventCapture";

		HttpClient client = HttpClientBuilder.create().build();
		HttpPost post = new HttpPost(url);

		post.setEntity(new StringEntity(data, "UTF-8"));

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
