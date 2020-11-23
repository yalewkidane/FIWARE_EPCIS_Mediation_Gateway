package com.oliot.mediation.controller.ngsiLd;

import java.io.IOException;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oliot.mediation.service.ngsild.eventFactory.agrifood.AgrifoodEventProcessor;
import com.oliot.model.ngsi_ld.Agrifood.Animal;
import com.oliot.model.ngsi_ld.Subscriptions.AnimalSubscription;
import com.oliot.model.ngsi_ld.Subscriptions.RoomSubscription;



@Controller
public class AgrifoodSubscription {
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimal(@RequestBody String body){
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			//Gson gson = new GsonBuilder().serializeNulls().create();
			//roomSubscription = gson.fromJson(body, RoomSubscription.class); 
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/WelfareCondition", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalWelfareCondition(@RequestBody String body){
		System.out.println("/ngsi-ld/Subscribe/Animal/WelfareCondition-update");
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			ObjectMapper om = new ObjectMapper();
			try {
				animalSubscription = om.readValue(body, AnimalSubscription.class);
				List<Animal> animals = animalSubscription.getData();
				AgrifoodEventProcessor agrifoodEP = new AgrifoodEventProcessor();
				String status = agrifoodEP.welfareCheckup(animals);
				System.out.println(status);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
//			Gson gson = new GsonBuilder().serializeNulls().create();
//			animalSubscription = gson.fromJson(body, AnimalSubscription.class); 
			
			
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
			//System.out.println(animalSubscription.getId());
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/CalvedBy", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalCalvedBy(@RequestBody String body){
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			animalSubscription = gson.fromJson(body, AnimalSubscription.class); 
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
			System.out.println(animalSubscription.getId());
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/Weight", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalWeight(@RequestBody String body){
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			animalSubscription = gson.fromJson(body, AnimalSubscription.class); 
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
			System.out.println(animalSubscription.getId());
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/LocatedAt", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalLocatedAt(@RequestBody String body){
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			animalSubscription = gson.fromJson(body, AnimalSubscription.class); 
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
			System.out.println(animalSubscription.getId());
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/OwnedBy", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalOwnedBy(@RequestBody String body){
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			animalSubscription = gson.fromJson(body, AnimalSubscription.class); 
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
			System.out.println(animalSubscription.getId());
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/PhenologicalCondition", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalPhenologicalCondition(@RequestBody String body){
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			animalSubscription = gson.fromJson(body, AnimalSubscription.class); 
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
			System.out.println(animalSubscription.getId());
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/ReproductiveCondition", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalReproductiveCondition(@RequestBody String body){
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			animalSubscription = gson.fromJson(body, AnimalSubscription.class); 
			//System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
			System.out.println(animalSubscription.getId());
		}
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Animal/HealthCondition", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeAnimalHealthCondition(@RequestBody String body){
		System.out.println("/ngsi-ld/Subscribe/Animal/HealthCondition");
		System.out.println(body);
		AnimalSubscription animalSubscription = new AnimalSubscription();
		if(body!=null) {
			ObjectMapper om = new ObjectMapper();
			try {
				animalSubscription = om.readValue(body, AnimalSubscription.class);
				List<Animal> animals = animalSubscription.getData();
				AgrifoodEventProcessor agrifoodEP = new AgrifoodEventProcessor();
				String status = agrifoodEP.healthCheckup(animals);
				System.out.println(status);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	
	

}
