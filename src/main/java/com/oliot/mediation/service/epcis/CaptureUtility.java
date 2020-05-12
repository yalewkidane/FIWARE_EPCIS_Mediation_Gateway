package com.oliot.mediation.service.epcis;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Authenticator;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.PasswordAuthentication;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;

import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.client.HttpClientBuilder;

import com.oliot.mediation.configuration.Configuration;



public class CaptureUtility implements HostnameVerifier{
	
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
	
	public  static int registerEPCISAuth(String data) throws IOException {
		
		String url = "https://iof.epcat.de/UC5.1/capture";
		
		CredentialsProvider provider = new BasicCredentialsProvider();
		
		UsernamePasswordCredentials credentials
		 = new UsernamePasswordCredentials("kaist", "3fgE2MHewrVbs");
		
		provider.setCredentials(AuthScope.ANY, credentials);
		
		HttpClient client = HttpClientBuilder.create()
				  .setDefaultCredentialsProvider(provider)
				  .build();
		
		//HttpClient client = HttpClientBuilder.create().build();
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
	
	
	public  int registerEPCIS(String data, String auth) throws IOException {
		
		String url = "https://iof.epcat.de/UC5.1/capture";
		
		CredentialsProvider provider = new BasicCredentialsProvider();
		
		UsernamePasswordCredentials credentials
		 = new UsernamePasswordCredentials("kaist", "3fgE2MHewrVbs");
		
		provider.setCredentials(AuthScope.ANY, credentials);
		
		HttpClient client = HttpClientBuilder.create()
				  .setDefaultCredentialsProvider(provider)
				  .build();
		
		//HttpClient client = HttpClientBuilder.create().build();
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
		
		//return doPost(data, "application/xml");
		
	}
	
    private  HttpURLConnection getConnection(final String contentType) throws  IOException {
        URL serviceUrl=null;
        String captureUrl="https://iof.epcat.de/UC5.1/capture";
        try {
            serviceUrl = new URL(captureUrl);
        } catch (MalformedURLException e) {
            
        }
        HttpURLConnection connection;
        SSLContext sslContext = null;
        
        final String username = "kaist";
        final String password = "3fgE2MHewrVbs";
        
        Authenticator.setDefault(new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(username, password.toCharArray());
            }
        });  

        connection = (HttpURLConnection) serviceUrl.openConnection();
        if (sslContext != null && connection instanceof HttpsURLConnection) {
            HttpsURLConnection httpsConnection = (HttpsURLConnection) connection;
            httpsConnection.setHostnameVerifier(this);
            httpsConnection.setSSLSocketFactory(sslContext.getSocketFactory());
        }
        connection.setRequestProperty("content-type", contentType);
        try {
            connection.setRequestMethod("POST");
        } catch (ProtocolException e) {
        }
        connection.setDoInput(true);
        connection.setDoOutput(true);
        return connection;
    }
	
     int doPost(final String data, final String contentType) throws IOException {
        HttpURLConnection connection = getConnection(contentType);
        // write the data
        OutputStreamWriter wr = new OutputStreamWriter(connection.getOutputStream());
        wr.write(data);
        wr.flush();
        wr.close();

        return connection.getResponseCode();
    }


	@Override
	public boolean verify(String arg0, SSLSession arg1) {
		// TODO Auto-generated method stub
		return true;
	}
	
	

}
