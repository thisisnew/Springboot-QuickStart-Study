package com.rubypaper;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Service;

import ch.qos.logback.classic.Logger;

@Service
public class LoggingRunner implements ApplicationRunner{
	
	private Logger logger = (Logger) org.slf4j.LoggerFactory.getLogger(LoggingRunner.class);

	@Override
	public void run(ApplicationArguments args) throws Exception {
		logger.trace("TRACE 로그 메시지");
		logger.debug("DEBUG 로그 메시지");
		logger.info("INFO 로그 메시지");
		logger.warn("WARN 로그 메시지");
		logger.error("ERROR 로그 메시지");
	}
}
