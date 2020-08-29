package com.event.network.document;

import java.io.File;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document(collection = "USER_COMMENT_DETAILS")
public class UserComment {
	
	public UserComment() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserComment(String mongoId, long userId, long eventId, File file) {
		super();
		this.mongoId = mongoId;
		this.userId = userId;
		this.eventId = eventId;
		this.file = file;
	}

	@Id
	private String mongoId;
	
	@Field("USER_ID")
	private long userId;
	
	@Field("EVENT_ID")
	private long eventId;
	
	@Field("FILE")
	private File file;

	public String getMongoId() {
		return mongoId;
	}

	public void setMongoId(String mongoId) {
		this.mongoId = mongoId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public long getEventId() {
		return eventId;
	}

	public void setEventId(long eventId) {
		this.eventId = eventId;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "UserComment [mongoId=" + mongoId + ", userId=" + userId + ", eventId=" + eventId + ", file=" + file
				+ "]";
	}
	
}
