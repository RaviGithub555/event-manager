package com.event.network.document;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "EVENT_DETAILS")
public class EventDetails {
	
	public EventDetails(String mongoId, long id, String event_name, String eventCatagory, Date starTime, Date endTime,
			long numOfDays, double avgRating) {
		super();
		this.mongoId = mongoId;
		this.id = id;
		this.event_name = event_name;
		this.eventCatagory = eventCatagory;
		this.starTime = starTime;
		this.endTime = endTime;
		this.numOfDays = numOfDays;
		this.avgRating = avgRating;
	}

	public EventDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	@Id
	private String mongoId;
	
	@Field("EVENT_ID")
	private long id;
	
	@Field("EVENT_NAME")
	private String event_name;
	
	@Field("EVENT_CATAGORY")
	private String eventCatagory;
	
	@Field("START_TIME")
	private Date starTime;
	
	@Field("END_TIME")
	private Date endTime;
	
	@Field("NUMBER_OF_DAYS")
	private long numOfDays;
	
	@Field("USER_AVG_RATING")
	private double avgRating;

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEvent_name() {
		return event_name;
	}

	public void setEvent_name(String event_name) {
		this.event_name = event_name;
	}

	public String getEventCatagory() {
		return eventCatagory;
	}

	public void setEventCatagory(String eventCatagory) {
		this.eventCatagory = eventCatagory;
	}

	public Date getStarTime() {
		return starTime;
	}

	public void setStarTime(Date starTime) {
		this.starTime = starTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public long getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(long numOfDays) {
		this.numOfDays = numOfDays;
	}

	public double getAvgRating() {
		return avgRating;
	}

	public void setAvgRating(double avgRating) {
		this.avgRating = avgRating;
	}
}
