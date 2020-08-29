package com.event.network.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.stereotype.Service;
import com.event.network.document.EventDetails;
import com.event.network.document.UserComment;
import com.event.network.service.EventService;

@Service("EventServiceImpl")
public class EventServiceImpl implements EventService{

	@Autowired
	MongoOperations mongoOperations;
	
	
	@Override
	public EventDetails publishEvent(EventDetails eventDtls) throws Exception {

		EventDetails eventData = null;
		try {
			if(eventDtls!=null && !eventDtls.equals(""))
			{
				eventData =  mongoOperations.save(eventDtls, "EVENT_DETAILS");
			}
		} catch (Exception e) {
			
			return eventData;
		}
		return eventData;
	}

	@Override
	public List<EventDetails> fetchAllEvent() throws Exception {
		List<EventDetails> eventList = null;
		try {
			eventList = mongoOperations.findAll(EventDetails.class, "EVENT_DETAILS");
			if(eventList!=null)
			{
				System.out.println("event list successfully fetched");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return eventList;
	}

	@Override
	public UserComment userCommentPost(UserComment userComment) throws Exception {
		UserComment userRspo = null;
		
		try {
			if(userComment!=null && !userComment.equals(""))
			{
				userRspo =  mongoOperations.save(userComment, "USER_COMMENT_DETAILS");
			}
		} catch (Exception e) {
			
			return userRspo;
		}
		return userRspo;
	}
	
}
