package com.event.network;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EventApplication{	
	
	protected static Logger logger = LogManager.getLogger(EventApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(EventApplication.class, args);
	}
}


