package hello.clock;

import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import hello.Greeting;

@Component
public class Clock {

	Logger logger = LoggerFactory.getLogger(Clock.class);

	private SimpMessagingTemplate simpMessagingTemplate;

	public Clock(SimpMessagingTemplate simpMessagingTemplate) {
		this.simpMessagingTemplate = simpMessagingTemplate;
		logger.info("Starting clock");
	}

	@Scheduled(fixedDelay = 5000, initialDelay = 5000)
	// @SendTo("/topic/clock")
	public void update() {
		Date now = new Date();
		logger.info("Updating Clock: " + now);
		simpMessagingTemplate.convertAndSend("/topic/clock", new Greeting(now.toString()));
	}
}
