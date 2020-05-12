package com.oliot.mediation;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

public interface Mediation_Gateway {
	
	@RequestMapping(value="/Subscribe/Farm/SlaughterHouse", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeFarmSlaughterHouse(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Farm/Pig", method = RequestMethod.POST)
	@ResponseBody
	public String SubscribeFarmPig(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Farm/Farm", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeFarmFarm(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Farm/Building", method = RequestMethod.POST)
	@ResponseBody
	public String SubscribeFarmBuilding(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Farm/Compartment", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeFarmCompartment(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Farm/Pen", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeFarmPen(@RequestBody String body); 
	

	
	
	@RequestMapping(value="/Subscribe/Environment", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeEnvironment(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Environment/AeroAllergenObserved", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeEnvironmentAeroAllergenObserved(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Environment/AirQualityObserved", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeEnvironmentAirQualityObserved(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Environment/NoiseLevelObserved", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeEnvironmentNoiseLevelObserved(@RequestBody String body);
	
	@RequestMapping(value="/Subscribe/Environment/WaterQualityObserved", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeEnvironmentWaterQualityObserved(@RequestBody String body);

}
