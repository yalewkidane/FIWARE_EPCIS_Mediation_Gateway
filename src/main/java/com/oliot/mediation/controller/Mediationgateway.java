package com.oliot.mediation.controller;



import java.io.IOException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oliot.mediation.configuration.Configuration;
import com.oliot.mediation.service.fiware.QueryUtilility;

@Controller
public class Mediationgateway {

	//@Value("${local.server.address}")
    //private String serverAddress;
	

	@RequestMapping("/")
    public String home(Model model){
		//System.out.println("Home is being processed");
		model.addAttribute("fiwareURL", Configuration.fiwareURL);
		model.addAttribute("epcisURl", Configuration.epcisURL);
		model.addAttribute("mediationGatewayURL", Configuration.mediationGatewayURL);

        return "index";
    }
	
	@RequestMapping(value="/GetByUrl" , method = RequestMethod.GET)
	@ResponseBody
    public ResponseEntity<?> testGetMethod(@RequestParam(required = false) String url) throws IOException {
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/text; charset=utf-8");
		//Need implementation 
		String result="testGetDediation";
		if(url!=null) {
			result=QueryUtilility.normalquery(url);
			
		}
		return new ResponseEntity<>(result, responseHeaders, HttpStatus.OK);
    }
	
	@RequestMapping(value="/Subscribe", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<?> Subscribe(@RequestBody String body) throws IOException{
		System.out.println(body);
		HttpHeaders responseHeaders = new HttpHeaders();
		responseHeaders.add("Content-Type", "application/text; charset=utf-8");
		String result="Staus\n";
		String url="http://"+Configuration.fiwareURL+"/v2/subscriptions";
		result=QueryUtilility.post(url, body);
		return new ResponseEntity<>(result, responseHeaders, HttpStatus.OK);
		
	}
	
	
    @RequestMapping("/FiwareDataModel")
    public String FiwareDataModel() {
		//System.out.println("Home is being processed");
        return "FiwareDataModel";
    }
	
	@RequestMapping("/home")
    public String test(Model model) {
		model.addAttribute("fiwareURL", Configuration.fiwareURL);
		model.addAttribute("epcisURl", Configuration.epcisURL);
		model.addAttribute("mediationGatewayURL", Configuration.mediationGatewayURL);
        return "Home";
    }
	
	 @RequestMapping("/meat")
	    public String MeatJson() {
			//System.out.println("Home is being processed");
	        return "MeatJson";
	    }
	 @RequestMapping("/test")
	    public String TestJson() {
			//System.out.println("Home is being processed");
	        return "TestJson";
	    }
}
