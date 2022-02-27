package com.games.user.service;

import java.util.concurrent.atomic.AtomicLong;

import com.games.user.service.client.BattleServiceClient;
import com.games.user.service.client.StatisticServiceClient;
import com.games.user.service.model.Greeting;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

	private static final String template = "User-Service - Hello, %s! - %s - %s";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private BattleServiceClient battleServiceClient;

	@Autowired
	private StatisticServiceClient statisticServiceClient;

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {

		return new Greeting(
			counter.incrementAndGet(),
			String.format(template, name, getGreetingsFromFromServiceB(), getGreetingsFromFromServiceC()));
	}

	private String getGreetingsFromFromServiceB() {
		Greeting greeting = battleServiceClient.getGreetingMessage();

		return greeting != null ? greeting.getContent() + " - " + greeting.getId() : "Battle Service Not Available";
	}

	private String getGreetingsFromFromServiceC() {
		Greeting greeting = statisticServiceClient.getGreetingMessage();

		return greeting != null ? greeting.getContent() + " - " + greeting.getId() : "Statistic Service Not Available";
	}
}