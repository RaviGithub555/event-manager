package com.event.network.controller;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.event.network.document.EventDetails;
import com.event.network.service.EventService;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/eventManager")
public class EventMangerController {

	@Autowired(required=true)
	EventService eventService;
	
	@Autowired
	MongoOperations mongoOperations;
	

	/** The Constant logger. */
	@SuppressWarnings("unused")
	private static final Logger logger = LogManager.getLogger(EventMangerController.class);

	@PostMapping("/publishEvent")
	public ResponseEntity<JSONObject> publishEvent(@RequestBody EventDetails eventDtls)throws Exception
	{
		JSONObject eventJsonDtls = null;
		EventDetails eventRsp = null;
		try {
			if(eventDtls!=null && !eventDtls.equals(""))
			{
				eventRsp = eventService.publishEvent(eventDtls);
				if(eventRsp!=null && !eventRsp.equals(""))
				{
					eventJsonDtls = new JSONObject();
					eventJsonDtls.put("eventStatus", "SUCCESS");
					eventJsonDtls.put("eventDtls", eventRsp);
				}
			}
		} catch (Exception e) {
			
			eventJsonDtls = new JSONObject();
			eventJsonDtls.put("eventStatus", "FAILED");
			eventJsonDtls.put("eventDtls", "details not saved");
			return new ResponseEntity<JSONObject>(eventJsonDtls, HttpStatus.OK);
		}
		return new ResponseEntity<JSONObject>(eventJsonDtls, HttpStatus.OK);
	}
	
	@PostMapping("/fetchAllEvent")
	public ResponseEntity<JSONObject> fetchAllEvent()throws Exception
	{
		JSONObject allEvents = null;
		try {
			
			List<EventDetails> fetchAllEvent = eventService.fetchAllEvent();
			
			if(fetchAllEvent!=null && !fetchAllEvent.equals(""))
			{
				allEvents = new JSONObject();
				allEvents.put("eventStatus", "SUCCESS");
				allEvents.put("eventDtls", fetchAllEvent);
			}
		} catch (Exception e) {
			
			allEvents = new JSONObject();
			allEvents.put("eventStatus", "FAILED");
			allEvents.put("eventDtls", "details not saved");
			return new ResponseEntity<JSONObject>(allEvents, HttpStatus.OK);
		}
		return new ResponseEntity<JSONObject>(allEvents, HttpStatus.OK);
	}
}
