package com.oliot.mediation.controller.ngsiLd;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.oliot.model.fiware.Test.Room;
import com.oliot.model.ngsi_ld.Subscriptions.RoomSubscription;

@Controller
public class NgsiLdSubscriptions { 
	@RequestMapping(value="/NGSI_LD/Subscribe/Test", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeTest(@RequestBody String body){
		System.out.println(body);
		
		
	}
	@RequestMapping(value="/ngsi-ld/Subscribe/Room", method = RequestMethod.POST)
	@ResponseBody
	public void SubscribeRoom(@RequestBody String body){
		System.out.println(body);
		RoomSubscription roomSubscription = new RoomSubscription();
		if(body!=null) {
			Gson gson = new GsonBuilder().serializeNulls().create();
			roomSubscription = gson.fromJson(body, RoomSubscription.class); 
			System.out.println(roomSubscription.getNotifiedAt());
			//room = (Room) gson.fromJson(body, Subscribition.class).getData()[0];
			//System.out.println("****");
			//System.out.println(gson.fromJson(body, Subscribition.class).getData()[0]);
		}
	}
	

}
