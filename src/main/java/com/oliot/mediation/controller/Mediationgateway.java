package com.oliot.mediation.controller;



import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.oliot.mediation.configuration.Configuration;
import com.oliot.mediation.service.epcis.QueryResonse;
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
		QueryResonse response=new QueryResonse();
		if(url!=null) {
			response=QueryUtilility.normalquery(url);
			
		}
		return new ResponseEntity<>(response.getBody(), responseHeaders, HttpStatus.OK);
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
	@RequestMapping(value="/guide", method=RequestMethod.GET)
	public ResponseEntity<byte[]> getPDF() throws IOException {
	  

	    // retrieve contents of "C:/tmp/report.pdf" that were written in showHelp
	    byte[] contents = Files.readAllBytes(Paths.get("src/main/resources/templates/Guide.pdf"));
	    //String jsonString = IOUtils.toString(classLoader.getResourceAsStream("resources/Configuration.json"));

	    HttpHeaders headers = new HttpHeaders();
	    headers.setContentType(MediaType.parseMediaType("application/pdf"));
	    // if you want to download the file 
	    //String filename = "output.pdf";
	    //headers.setContentDispositionFormData(filename, filename);
	    headers.setCacheControl("must-revalidate, post-check=0, pre-check=0");
	    ResponseEntity<byte[]> response = new ResponseEntity<>(contents, headers, HttpStatus.OK);
	    return response;
	}

	 @RequestMapping("/about")
	    public String about() {
			//System.out.println("Home is being processed");
	        return "about";
	    }
	 @RequestMapping("/test")
	    public String TestJson() {
			//System.out.println("Home is being processed");
	        return "TestJson";
	    }
	 @RequestMapping("/farm")
	    public String FarmJson() {
			//System.out.println("Home is being processed");
	        return "farm_model/FarmJson";
	    }
	 @RequestMapping("/farm/building")
	    public String Farm_BuildingJson() {
			//System.out.println("Home is being processed");
	        return "farm_model/Farm_BuildingJson";
	    }
	 @RequestMapping("/farm/pen")
	    public String Farm_PenJson() {
			//System.out.println("Home is being processed");
	        return "farm_model/Farm_PenJson";
	    }
	 @RequestMapping("/farm/pig")
	    public String Farm_PigJson() {
			//System.out.println("Home is being processed");
	        return "farm_model/Farm_PigJson";
	    }
	 @RequestMapping("/farm/slaougterhouse")
	    public String Farm_SlaougterhouseJson() {
			//System.out.println("Home is being processed");
	        return "farm_model/Farm_SlaougterhouseJson";
	    }
	 @RequestMapping("/farm/slaughteredPig")
	    public String Farm_SlaughteredPigJson() {
			//System.out.println("Home is being processed");
	        return "farm_model/Farm_SlaughteredPigJson";
	    }
	 @RequestMapping("/farm/entityList")
	    public String FarmEntityListJson() {
			//System.out.println("Home is being processed");
	        return "farm_model/FarmEntityListJson";
	    }
	 @RequestMapping(value="/Get" , method = RequestMethod.GET)
		@ResponseBody
	    public ResponseEntity<?> get(@RequestParam(required = false) String url) throws IOException {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/text; charset=utf-8");
			//Need implementation 
			System.out.println(url);
			url=url.replace('!', '&');
			System.out.println(url);
			QueryResonse response=new QueryResonse();
			if(url!=null) {
				response=QueryUtilility.normalquery(url);
				
			}
			return new ResponseEntity<>(response.getBody(), responseHeaders, HttpStatus.OK);
	    }
	 
	 @RequestMapping(value="/Post", method = RequestMethod.POST)
		@ResponseBody
		public ResponseEntity<?> post(@RequestBody String body, @RequestParam(required = false) String url) throws IOException{
			//System.out.println(body);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/text; charset=utf-8");
			String result="Staus\n";
			result=QueryUtilility.post(url, body);
			return new ResponseEntity<>(result, responseHeaders, HttpStatus.OK);
			
		}
	 
	 @RequestMapping(value="/Patch", method = RequestMethod.PATCH)
		@ResponseBody
		public ResponseEntity<?> patch(@RequestBody String body, @RequestParam(required = false) String url) throws IOException{
			//System.out.println(body);
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/text; charset=utf-8");
			String result="Staus\n";
			System.out.println("method: Patch");
			System.out.println("url: "+url);
			System.out.println("body: "+ body);
			result=QueryUtilility.patch(url, body);
			return new ResponseEntity<>(result, responseHeaders, HttpStatus.OK);
			
		}
	// /*  // This is to test ngrinder 
	 @RequestMapping(value="/Delete" , method = RequestMethod.DELETE)
		@ResponseBody
	    public ResponseEntity<?> delete(@RequestParam(required = false) String url) {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/text; charset=utf-8");
			//Need implementation 
			String result="Check the URL";
			if(url!=null) {
				result=QueryUtilility.delete(url);
				
			}
			return new ResponseEntity<>(result, responseHeaders, HttpStatus.OK);
	    }
	 int xx=0;
	 @RequestMapping(value="/ngrinder/get" , method = RequestMethod.GET)
		@ResponseBody
	    public ResponseEntity<?> nGrinderGet() throws IOException {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/text; charset=utf-8");
			//System.out.println("X:" +xx);
			//xx++;
			
			
			return new ResponseEntity<>("Ok", responseHeaders, HttpStatus.OK);
	    }
	 @RequestMapping(value="/ngrinder/post" , method = RequestMethod.POST)
		@ResponseBody
	    public ResponseEntity<?> nGrinderPost(@RequestBody String body) throws IOException {
			HttpHeaders responseHeaders = new HttpHeaders();
			responseHeaders.add("Content-Type", "application/text; charset=utf-8");
			System.out.println("body:" +body);
			
			
			
			return new ResponseEntity<>("Ok", responseHeaders, HttpStatus.OK);
	    }
	   // */
}
