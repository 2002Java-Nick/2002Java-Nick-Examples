package com.revature.driver;

import org.apache.log4j.Logger;

public class LogDriver {
	
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		log.fatal("Fatal message");
		log.error("Error Message");
		log.warn("Warn message");
		log.debug("Debug message");
		log.info("Info message");
		log.trace("Trace message");
	}

}
