package com.event.network.service;

import java.util.List;
import org.springframework.stereotype.Service;
import com.event.network.document.EventDetails;
import com.event.network.document.UserComment;

@Service
public interface EventService {
	
  public EventDetails publishEvent(EventDetails eventDtls) throws Exception;
  public List<EventDetails> fetchAllEvent() throws Exception;
  public UserComment userCommentPost(UserComment userComment) throws Exception;
}
